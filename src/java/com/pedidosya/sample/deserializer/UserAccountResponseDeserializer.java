package com.pedidosya.sample.deserializer;

import com.google.gson.Gson;
import com.pedidosya.sample.vo.responses.UserAccountResponse;

/**
 * Clase encargada de deserializar la respuesta json a un objeto java para el
 * del servicio de obtenicion de los datos del usuario.
 * 
 * 
 * @author Gaspar Medina
 * @date - 24-04-2016
 *
 */
public class UserAccountResponseDeserializer {

	/**
	 * Metodo encargado de deserializar la respuesta json a un objeto java
	 * 
	 * @param jsonResponse
	 * @return objeto java.
	 */
	public UserAccountResponse deserializeResponse(String jsonResponse) {
		Gson gson = new Gson();
		UserAccountResponse userAccountResponse = (UserAccountResponse) gson
				.fromJson(jsonResponse, UserAccountResponse.class);
		return userAccountResponse;
	}
}
