package com.pedidosya.sample.filters

/**
 * Clase encargada de definir filtros de acceso a nuestra aplicacion
 * @author Gaspar Medina
 * @date - 25-04-2016
 *
 */
class SecurityFilters {


	/**
	 * Acciones que necesitan login del usuario
	 */
	static authenticatedActions = [[controller: 'user', action: 'content']]


	def filters = {

		all(controller: '*', action: '*') {
			before = {

				//Buscamos en nuestro arreglo de controladores y acciones el controlador y la accion en ejeucion.
				def controllerActionFound = authenticatedActions.find {
					(it.controller == controllerName) && (it.action == actionName)
				}
				//Obtenemos la session del usuario
				def userSession = session.userAccountResponse
				//So el controlador y la accion en ejecucion fueron encontradas y la session del usuario no existe entonces no lo dejamos ver este
				//controlador ni accion.
				if (controllerActionFound && userSession == null) {
					render(status: 401, text: '401 	No Autorizado: Acceso denegado. Usted no tiene permisos para ver esta pagina.')
					return false
				}

			}
		}
	}
}
