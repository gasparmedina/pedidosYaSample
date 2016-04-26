package com.pedidosya.sample

import com.pedidosya.sample.vo.responses.SearchRestaurantsResponse
/**
 * Controlador encargado de implementar acciones relaciondas a las acciones del usaurio
 *
 * @author Gaspar Medina
 * @date 25-04-2016
 *
 */
class UserController {

	def pedidosYaService;

	def content = {
		if (params.latitud != null && params.Longitud != null) {
			//Obtenemos los restaurantes a partir de la ubicacion dada de su latitud y longitud
			SearchRestaurantsResponse searchRestaurantsResponse = pedidosYaService.searchRestaurants(params.latitud,params.Longitud,session.userAuthenticationResponse.accesToken)

			//Si la lista de restaurantes esta vacia le informamos al usuario
			if (searchRestaurantsResponse.getData().empty) {
				[params: [restaurantsNotFound: 'true']]
			}else{
				[restaurants: searchRestaurantsResponse.getData()]
			}

		}

	}

}
