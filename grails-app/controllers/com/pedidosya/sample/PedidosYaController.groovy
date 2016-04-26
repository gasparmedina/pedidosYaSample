package com.pedidosya.sample
/**
 * Controlador encargado de implementar acciones relaciondas a la autenticacion del usuario.
 * 
 * @author Gaspar Medina
 * @date 23-04-2016
 *
 */

import com.pedidosya.sample.vo.responses.AppAuthenticateResponse
import com.pedidosya.sample.vo.responses.UserAccountResponse
import com.pedidosya.sample.vo.responses.UserAuthenticateResponse
import org.codehaus.groovy.grails.commons.GrailsApplication
class PedidosYaController {

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
		}else{		
	    	//Obtenemos el accesToken del usuario
			UserAuthenticateResponse responseAuthenticateUser = pedidosYaService.userAuthenticate(responseAppAuthenticate.getAccesToken(),params.email,params.password)
			//Si la autenticacion del usuario no fue exitosa le informamos al usuario
			if (!responseAuthenticateUser.getCode().equals(AppAuthenticateResponse.SUCCES_CODE)) {
				redirect(uri:'/',params: [userAuthenticateFailed: 'true'])
			}else{
				//Si la autenticacion del usuario fue exitosa obtenemos sus datos personales
				UserAccountResponse userAccountResponse = pedidosYaService.getUserAccountInfo(responseAuthenticateUser.getAccesToken())
				//Si la obtencion de los datos de usuario no fue exitosa le informamos al usuario
				if (!userAccountResponse.getCode().equals(UserAccountResponse.SUCCES_CODE)) {
					redirect(uri:'/',params: [getUserAccountFailed: 'true'])
				}else{
					//Si fue exitosa lo redireccionamos a su perfil, guardando sus datos en la session
				    session.userAccountResponse = userAccountResponse
					session.userAuthenticationResponse = responseAuthenticateUser
					redirect(controller: "user", action: "content")														
				}
			}
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
