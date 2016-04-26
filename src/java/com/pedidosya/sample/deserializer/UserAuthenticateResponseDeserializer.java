package com.pedidosya.sample.deserializer;

import com.google.gson.Gson;
import com.pedidosya.sample.vo.responses.UserAuthenticateResponse;

/**
 * Clase encargada de deserializar la respuesta json a un objeto java para el
 * servicio de obtencion de token de login de usuario
 * 
 * 
 * @author Gaspar Medina
 * @date - 24-04-2016
 *
 */
public class UserAuthenticateResponseDeserializer {

	/**
	 * Metodo encargado de deserializar la respuesta json a un objeto java
	 * 
	 * @param jsonResponse
	 * @return objeto java.
	 */
	public UserAuthenticateResponse deserializeResponse(String jsonResponse) {
		Gson gson = new Gson();
		UserAuthenticateResponse appAuthenticateResponse = (UserAuthenticateResponse) gson
				.fromJson(jsonResponse, UserAuthenticateResponse.class);
		return appAuthenticateResponse;
	}
}
