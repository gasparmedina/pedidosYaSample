package com.pedidosya.sample.vo.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Esta clase contiene los atributos necesarios a la hora de mapear una
 * respuesta json para un restaurant.
 * 
 * @author Gaspar Medina
 * @date - 24-04-2016
 *
 */
public class Restaurant {

	@SerializedName("name")
	private String name;
	@SerializedName("topCategories")
	private String topCategories;
	@SerializedName("ratingScore")
	private Float ratingScore;
	@SerializedName("logo")
	private String logo;
	@SerializedName("deliveryTimeMaxMinutes")
	private int deliveryTimeMaxMinutes;
	@SerializedName("link")
	private String link;
	@SerializedName("opened")
	private int opened;
	// Representa las horas de tiempo de entrega maximo
	private int deliveryTimeMaxHours;
	// Representa los minutos de tiempo de entrega maximo
	private int deliveryTimeMaxHoursMinutes;

	// deliveryTimeMaxHoursMinutes y deliveryTimeMaxHours representan el tiempo
	// en el siguiente formato 1 hora y 50 minutos por ejemplo

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the topCategories
	 */
	public String getTopCategories() {
		return topCategories;
	}

	/**
	 * @param topCategories
	 *            the topCategories to set
	 */
	public void setTopCategories(String topCategories) {
		this.topCategories = topCategories;
	}

	/**
	 * @return the ratingScore
	 */
	public Float getRatingScore() {
		return ratingScore;
	}

	/**
	 * @param ratingScore
	 *            the ratingScore to set
	 */
	public void setRatingScore(Float ratingScore) {
		this.ratingScore = ratingScore;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo
	 *            the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the deliveryTimeMaxMinutes
	 */
	public int getDeliveryTimeMaxMinutes() {
		return deliveryTimeMaxMinutes;
	}

	/**
	 * @param deliveryTimeMaxMinutes
	 *            the deliveryTimeMaxMinutes to set
	 */
	public void setDeliveryTimeMaxMinutes(int deliveryTimeMaxMinutes) {
		this.deliveryTimeMaxMinutes = deliveryTimeMaxMinutes;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the opened
	 */
	public int getOpened() {
		return opened;
	}

	/**
	 * @param opened
	 *            the opened to set
	 */
	public void setOpened(int opened) {
		this.opened = opened;
	}

	/**
	 * @return the deliveryTimeMaxHours
	 */
	public int getDeliveryTimeMaxHours() {
		return deliveryTimeMaxHours;
	}

	/**
	 * @param deliveryTimeMaxHours
	 *            the deliveryTimeMaxHours to set
	 */
	public void setDeliveryTimeMaxHours(int deliveryTimeMaxHours) {
		this.deliveryTimeMaxHours = deliveryTimeMaxHours;
	}

	/**
	 * @return the deliveryTimeMaxHoursMinutes
	 */
	public int getDeliveryTimeMaxHoursMinutes() {
		return deliveryTimeMaxHoursMinutes;
	}

	/**
	 * @param deliveryTimeMaxHoursMinutes
	 *            the deliveryTimeMaxHoursMinutes to set
	 */
	public void setDeliveryTimeMaxHoursMinutes(int deliveryTimeMaxHoursMinutes) {
		this.deliveryTimeMaxHoursMinutes = deliveryTimeMaxHoursMinutes;
	}

}
