package com.pedidosya.sample.vo.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Esta clase contiene los atributos necesarios a la hora de mapear una
 * respuesta json del servicio para obtener los datos del usuario.
 * 
 * @author Gaspar Medina
 * @date - 24-04-2016
 *
 */
public class UserAccountResponse {

	public static final String SUCCES_CODE = "0";

	@SerializedName("name")
	private String name;
	@SerializedName("lastName")
	private String lastName;
	@SerializedName("code")
	private String code;
	@SerializedName("messages")
	private String[] messages;

	public UserAccountResponse() {
		this.code = SUCCES_CODE;
	}

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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the messages
	 */
	public String[] getMessages() {
		return messages;
	}

	/**
	 * @param messages
	 *            the messages to set
	 */
	public void setMessages(String[] messages) {
		this.messages = messages;
	}

}
