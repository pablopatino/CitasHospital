package com.hospitalCitas.hospitalCitas.dominio.modelo;

import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionValorRequerido;

public class ValidarCampos {
	
	public static void validarCampo(Object string, String mensaje) {
		if ( string == null || string.toString().isEmpty()) {
			throw new ExcepcionValorRequerido(mensaje);
		}
	}

}
