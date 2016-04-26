package com.pedidosya.sample.vo.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Esta clase contiene los atributos necesarios a la hora de mapear una
 * respuesta json del servicio para obtener el token de login de usuario.
 * 
 * @author Gaspar Medina
 * @date - 24-04-2016
 *
 */
public class UserAuthenticateResponse {

	public static final String SUCCES_CODE = "0";

	@SerializedName("access_token")
	private String accesToken;
	@SerializedName("code")
	private String code;
	@SerializedName("messages")
	private String[] messages;

	public UserAuthenticateResponse() {
		this.code = SUCCES_CODE;
	}

	/**
	 * @return the accesToken
	 */
	public String getAccesToken() {
		return accesToken;
	}

	/**
	 * @param accesToken
	 *            the accesToken to set
	 */
	public void setAccesToken(String accesToken) {
		this.accesToken = accesToken;
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
