package com.pedidosya.sample

import com.pedidosya.sample.deserializer.AppAuthenticateResponseDeserializer
import com.pedidosya.sample.util.PropertyUtil;
import com.pedidosya.sample.vo.responses.AppAuthenticateResponse

import grails.plugins.rest.client.RestBuilder
import groovy.json.JsonSlurper

/**
 * Servicio encargado de implementar metodos relacionados a la autenticacion del usuario y obtencion de informacion
 * del perfil del usuario de PedidosYa
 * 
 * @author Gaspar Medina
 * @date 23-04-2016
 *
 */
class PedidosYaService {

	static final String PROPERTY_KEY_URL_TOKENS = 'com.pedidosya.sample.url.tokens'
	static final String PROPERTY_KEY_URL_MY_ACCOUNT = 'com.pedidosya.sample.url.myaccount'
	static final String PROPERTY_KEY_CLIENT_ID = 'com.pedidosya.sample.clientid'
	static final String PROPERTY_KEY_CLIENT_SECRET = 'com.pedidosya.sample.clientsecret'
	static final String AUTHORIZATION_HEADER = 'Authorization'
	static final String PARAM_CLIENT_ID = "clientId"
	static final String PARAM_CLIENT_SECRET = "clientSecret"
	static final String PARAM_USERNAME = "userName"
	static final String PARAM_PASSWORD = "password"

	static transactional = false

	/**
	 * Metodo encargado de realizar la autentiacion contra la API Rest de PedidosYa y asi obtener un 
	 * token de acceso para acceder a los diferentes servicios de la API.
	 *    
	 * @return token de acceso de la aplicacion.
	 */
	AppAuthenticateResponse appAuthenticate() {

		//Obtenemos la URL de acceso y el ususario  y password
		String url = PropertyUtil.getPropertyValue(PROPERTY_KEY_URL_TOKENS)
		String clientId = PropertyUtil.getPropertyValue(PROPERTY_KEY_CLIENT_ID)
		String clientSecret = PropertyUtil.getPropertyValue(PROPERTY_KEY_CLIENT_SECRET)

		//Armamos la url con sus parametros
		String urlParams = url+"?"+PARAM_CLIENT_ID+"="+clientId+"&"+PARAM_CLIENT_SECRET+"="+clientSecret

		//Invocamos al servicio REST para obtener el accesToken
		def serviceResponse = new RestBuilder().get(urlParams).json

		//Deseralizamos la respuesta obtenida del servicio
		AppAuthenticateResponseDeserializer appAuthenticateDeserializer = new AppAuthenticateResponseDeserializer();
		AppAuthenticateResponse responseDeserializer = appAuthenticateDeserializer.deserializeResponse(serviceResponse.toString())

		return responseDeserializer
	}

	/**
	 * Metodo encargado de realizar la autenticacion de un usuario contra la API de PedidosYa
	 * @param appAccesToken
	 * @return token de acceso a la iformacion del usuario
	 */
	String userAuthenticate(String appAccesToken,String email,String password){

		//Obtenemos la URL de acceso
		String url = PropertyUtil.getPropertyValue(PROPERTY_KEY_URL_TOKENS)

		//Armamos la url con sus parametros
		String urlParams = url+"?"+PARAM_USERNAME+"="+email+"&"+PARAM_PASSWORD+"="+password

		//Invocamos al servicio REST para obtener el accesToken
		def serviceResponse = new RestBuilder().get(urlParams){ header AUTHORIZATION_HEADER, appAccesToken }.json

		//Convertimos la respuesta de tipo JSON a un objeto groovy para poder extraer el valor del accesToken
		JsonSlurper jsonSlurper = new JsonSlurper();
		def result = jsonSlurper.parseText(serviceResponse.toString());
		def userAccesToken = result.access_token
		return userAccesToken
	}




}
