package com.pedidosya.sample.deserializer;

import com.google.gson.Gson;
import com.pedidosya.sample.vo.responses.AppAuthenticateResponse;

/**
 * Clase encargada de deserializar la respuesta json a un objeto java
 * 
 * 
 * @author Gaspar Medina
 * @date - 24-04-2016
 *
 */
public class AppAuthenticateResponseDeserializer {

	/**
	 * Metodo encargado de deserializar la respuesta json a un objeto java
	 * @param jsonResponse
	 * @return objeto java.
	 */
	public AppAuthenticateResponse deserializeResponse(String jsonResponse) {
		Gson gson = new Gson();
		AppAuthenticateResponse appAuthenticateResponse = (AppAuthenticateResponse) gson
				.fromJson(jsonResponse, AppAuthenticateResponse.class);
		return appAuthenticateResponse;
	}

}
