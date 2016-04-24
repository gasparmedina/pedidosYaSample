package com.pedidosya.sample
/**
 * Controlador encargado de implementar acciones relaciondas a la autenticacion del usuario.
 * 
 * @author Gaspar Medina
 * @date 23-04-2016
 *
 */

import com.pedidosya.sample.vo.responses.AppAuthenticateResponse
import org.codehaus.groovy.grails.commons.GrailsApplication
class LoginController {

	def pedidosYaService;

	/**
	 * Accion encargada de realizar el proceso de ingreso a la aplicacion para un usuario.
	 */
	def login = {
										
		//Obtenemos un accesToken para poder tener acceso a la API rest de PedidosYa
		AppAuthenticateResponse responseAppAuthenticate = pedidosYaService.appAuthenticate()
		//Si la autenticacion no fue exitosa le informamos al usuario
		if (!responseAppAuthenticate.getCode().equals(AppAuthenticateResponse.SUCCES_CODE)) {
			redirect(uri:'/',params: [appAuthenticateFailed: 'true'])			
		}
				
	}

	/**
	 * Accion encargada de realizar el proceso de salida de la aplicacion para un usuario.
	 */
	def logout = {
		//Invalidamos la session.
		session.invalidate()
		redirect(uri:'/')
	}
}
