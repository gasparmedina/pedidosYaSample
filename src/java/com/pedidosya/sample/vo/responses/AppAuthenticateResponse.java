package com.pedidosya.sample.vo.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Clase utilizada para mapear la respuesta json que se obtiene al invocar al
 * servicio para obtener un accesToken de aplicacion de PedidosYa
 * 
 * @author Gaspar Medina
 * @date - 24-04-2016
 *
 */
public class AppAuthenticateResponse {

	public static final String SUCCES_CODE = "0";

	@SerializedName("access_token")
	private String accesToken;
	@SerializedName("code")
	private String code;
	@SerializedName("messages")
	private String[] messages;

	public AppAuthenticateResponse() {
		this.code = SUCCES_CODE;
	}

	public String getAccesToken() {
		return accesToken;
	}

	public void setAccesToken(String accesToken) {
		this.accesToken = accesToken;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

}
