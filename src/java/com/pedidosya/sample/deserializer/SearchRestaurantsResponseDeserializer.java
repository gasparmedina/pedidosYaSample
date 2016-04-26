package com.pedidosya.sample.deserializer;

import com.google.gson.Gson;
import com.pedidosya.sample.vo.responses.SearchRestaurantsResponse;

/**
 * Clase encargada de deserializar la respuesta json a un objeto java
 * 
 * 
 * @author Gaspar Medina
 * @date - 24-04-2016
 *
 */
public class SearchRestaurantsResponseDeserializer {
	

	/**
	 * Metodo encargado de deserializar la respuesta json a un objeto java
	 * 
	 * @param jsonResponse
	 * @return objeto java.
	 */
	public SearchRestaurantsResponse deserializeResponse(String jsonResponse) {
		Gson gson = new Gson();
		SearchRestaurantsResponse searchRestaurantsResponse = (SearchRestaurantsResponse) gson
				.fromJson(jsonResponse, SearchRestaurantsResponse.class);
		if (!searchRestaurantsResponse.getData().isEmpty()) {
			searchRestaurantsResponse.sortDataByRatingScore();
			searchRestaurantsResponse.buildExternalLink();
			searchRestaurantsResponse.buildLogoUrl();
			searchRestaurantsResponse.setDeliveryTimeMaxMinutesToHoursAndMinutes();
		}
		
		return searchRestaurantsResponse;
	}
}
