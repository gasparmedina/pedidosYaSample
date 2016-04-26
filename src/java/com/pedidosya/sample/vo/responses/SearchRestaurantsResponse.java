package com.pedidosya.sample.vo.responses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.pedidosya.sample.util.PropertyUtil;

/**
 * Esta clase contiene la lista de restaurantes que sera mapeada despues de
 * invocar al servicio de busqueda de restaurantes de PedidosYa
 * 
 * @author Gaspar Medina
 * @date - 24-04-2016
 *
 */
public class SearchRestaurantsResponse {

	private List<Restaurant> data;
	private final String PROPERTY_KEY_LOGO_URL = "com.pedidosya.sample.logo.url";
	private final String PROPERTY_KEY_EXTERNAL_LINK = "com.pedidosya.sample.external.link";

	public SearchRestaurantsResponse() {
		this.data = new ArrayList<Restaurant>();
	}

	/**
	 * @return the data
	 */
	public List<Restaurant> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(List<Restaurant> data) {
		this.data = data;
	}

	/**
	 * Metodo encargado de ordenar los restaurants por rating de forma
	 * descendiente
	 */
	public void sortDataByRatingScore() {
		Collections.sort(data, new Comparator<Restaurant>() {
			@Override
			public int compare(Restaurant a, Restaurant b) {
				return b.getRatingScore().compareTo(a.getRatingScore());
			}
		});
	}

	/**
	 * Metodo encargado de completar la URL del recurso que contiene la imagen
	 * del logo del restaurant
	 */
	public void buildLogoUrl() {
		String logoUrl = PropertyUtil.getPropertyValue(PROPERTY_KEY_LOGO_URL);
		for (Restaurant restaurant : data) {
			restaurant.setLogo(logoUrl + restaurant.getLogo());
		}
	}

	/**
	 * Metodo encargado de completar la URL hacia el link externo que dirige a
	 * la pagina del restaurant en el sitio de PedidosYa
	 */
	public void buildExternalLink() {
		String externalLink = PropertyUtil
				.getPropertyValue(PROPERTY_KEY_EXTERNAL_LINK);
		for (Restaurant restaurant : data) {
			restaurant.setLink(externalLink + restaurant.getLink() + "-menu");
		}
	}

	/**
	 * Metodo encargado de completar la cantidad maxima de horas si el tiempo
	 * maximo de de entrega es mayor a 60 minutos.
	 */
	public void setDeliveryTimeMaxMinutesToHoursAndMinutes() {
		for (Restaurant restaurant : data) {
			if (restaurant.getDeliveryTimeMaxMinutes() >= 60) {
				// Cargamos el valor en horas
				restaurant.setDeliveryTimeMaxHours(restaurant
						.getDeliveryTimeMaxMinutes() / 60);
				// Cargamos el valor en minutos
				restaurant.setDeliveryTimeMaxHoursMinutes(restaurant
						.getDeliveryTimeMaxMinutes() % 60);
			}
		}
	}



}
