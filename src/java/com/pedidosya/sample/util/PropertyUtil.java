package com.pedidosya.sample.util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Clase utilitaria encargada de definir metodos encargados de manejar las properties que se utilizaran en la aplicacion
 * 
 * @author Gaspar Medina
 * @date 24-04-2016
 * 
 *
 */
public class PropertyUtil {

	private final static String PROPERTY_FILE_NAME = "pedidosYaSample.properties";

	/**
	 * Metodo encargado de leer una property de aplicacion segun su propertyKey
	 * @param propertyKey
	 * @return valor de la property
	 */
	public static String getPropertyValue(String propertyKey) {
		String propertyResult = "";
		Properties props = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(
					PROPERTY_FILE_NAME);
			props.load(inputStream);
			propertyResult = props.getProperty(propertyKey);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return propertyResult;

	}
}
