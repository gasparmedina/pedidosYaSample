package com.pedidosya.sample

import com.pedidosya.sample.deserializer.AppAuthenticateResponseDeserializer
import com.pedidosya.sample.deserializer.SearchRestaurantsResponseDeserializer
import com.pedidosya.sample.deserializer.UserAccountResponseDeserializer
import com.pedidosya.sample.deserializer.UserAuthenticateResponseDeserializer
import com.pedidosya.sample.util.PropertyUtil;
import com.pedidosya.sample.vo.responses.AppAuthenticateResponse
import com.pedidosya.sample.vo.responses.SearchRestaurantsResponse
import com.pedidosya.sample.vo.responses.UserAccountResponse
import com.pedidosya.sample.vo.responses.UserAuthenticateResponse

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

	//Constantes que contienen las keys de las properties para obtener las URLs del servicio a invocar
	static final String PROPERTY_KEY_URL_TOKENS = 'com.pedidosya.sample.url.tokens'
	static final String PROPERTY_KEY_URL_MY_ACCOUNT = 'com.pedidosya.sample.url.myaccount'
	static final String PROPERTY_KEY_URL_SEARCH_RESTAURANTS = "com.pedidosya.sample.url.search.restaurants"

	//Constantes que contienen las keys de las properties para poder invocar al servicio de obtencion del acces_token de aplicacion
	static final String PROPERTY_KEY_CLIENT_ID = 'com.pedidosya.sample.clientid'
	static final String PROPERTY_KEY_CLIENT_SECRET = 'com.pedidosya.sample.clientsecret'

	//Constantes que contienen las keys de las properties para poder obtener un resulSet en la busqueda.
	static final String PROPERTY_KEY_MAX_RESTAURANTS_TO_SHOW = "com.pedidosya.sample.max.restaurants.opentoshow";
	static final String PROPERTY_KEY_FIELDS_RESULT_SEARCH = "com.pedidosya.sample.fields.result.search";

	//Constante que define un Header de autorizacion
	static final String AUTHORIZATION_HEADER = 'Authorization'

	//Paramtros utilizados para armar las URls de cada sercicio
	static final String PARAM_CLIENT_ID = "clientId"
	static final String PARAM_CLIENT_SECRET = "clientSecret"
	static final String PARAM_USERNAME = "userName"
	static final String PARAM_PASSWORD = "password"
	static final String PARAM_POINT = "point"
	static final String PARAM_MAX = "max"
	static final String PARAM_FIELDS = "fields"


	static transactional = false

	/**
	 * Metodo encargado de realizar la autentiacion contra la API Rest de PedidosYa y asi obtener un 
	 * token de acceso para acceder a los diferentes servicios de la API.
	 * @return respuesta del servicio
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
	 * @param email
	 * @param password
	 * @return respuesta del servicio
	 */
	UserAuthenticateResponse userAuthenticate(String appAccesToken,String email,String password){

		//Obtenemos la URL de acceso
		String url = PropertyUtil.getPropertyValue(PROPERTY_KEY_URL_TOKENS)

		//Armamos la url con sus parametros
		String urlParams = url+"?"+PARAM_USERNAME+"="+email+"&"+PARAM_PASSWORD+"="+password

		//Invocamos al servicio REST para obtener el accesToken
		def serviceResponse = new RestBuilder().get(urlParams){ header AUTHORIZATION_HEADER, appAccesToken }.json

		//Deseralizamos la respuesta obtenida del servicio
		UserAuthenticateResponseDeserializer userAuthenticateDeserializer = new UserAuthenticateResponseDeserializer();
		UserAuthenticateResponse responseDeserializer = userAuthenticateDeserializer.deserializeResponse(serviceResponse.toString())

		return responseDeserializer

	}

	/**
	 * Metodo encargado de obtener los datos del usaurio logueado
	 * @param userTokenAcces
	 * @return datos del usuario logueado
	 */
	UserAccountResponse getUserAccountInfo(String userTokenAcces){

		//Obtenemos la URL de acceso
		String url = PropertyUtil.getPropertyValue(PROPERTY_KEY_URL_MY_ACCOUNT)

		//Invocamos al servicio REST para obtener la informacion del usuario
		def serviceResponse = new RestBuilder().get(url){ header AUTHORIZATION_HEADER, userTokenAcces }.json

		//Deseralizamos la respuesta obtenida del servicio
		UserAccountResponseDeserializer userAccountResponseDeserializer = new UserAccountResponseDeserializer();
		UserAccountResponse userAccountResponse = userAccountResponseDeserializer.deserializeResponse(serviceResponse.toString())

		return userAccountResponse

	}

	/**
	 * Metodo encargado de obtener una lista de restaurants segun una ubicacion dada por su 
	 * latitud y longitud
	 * 
	 * @param latitud
	 * @param longitud
	 * @param userTokenAcces
	 * @return lista de restaurants
	 */
	SearchRestaurantsResponse searchRestaurants(String latitud, String longitud,String userTokenAcces){

		//Obtenemos la URL de acceso
		String url = PropertyUtil.getPropertyValue(PROPERTY_KEY_URL_SEARCH_RESTAURANTS)

		//Armamos la url con sus parametros
		String maxRestaurantsToShow = PropertyUtil.getPropertyValue(PROPERTY_KEY_MAX_RESTAURANTS_TO_SHOW)
		String fields = PropertyUtil.getPropertyValue(PROPERTY_KEY_FIELDS_RESULT_SEARCH)
		String urlParams = url+"?"+PARAM_POINT+"="+latitud+","+longitud+"&"+PARAM_MAX+"="+maxRestaurantsToShow+"&"+PARAM_FIELDS+fields

		//Invocamos al servicio REST para obtener la informacion del usuario
		def serviceResponse = new RestBuilder().get(urlParams){ header AUTHORIZATION_HEADER, userTokenAcces }.json

		//Deseralizamos la respuesta obtenida del servicio
		SearchRestaurantsResponseDeserializer searchRestaurantsResponseDeserializer = new SearchRestaurantsResponseDeserializer();
		SearchRestaurantsResponse searchRestaurantsResponse = searchRestaurantsResponseDeserializer.deserializeResponse(serviceResponse.toString())

		return searchRestaurantsResponse
	}






}
