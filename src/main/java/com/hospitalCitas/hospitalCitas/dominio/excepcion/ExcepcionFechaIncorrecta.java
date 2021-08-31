package com.hospitalCitas.hospitalCitas.dominio.excepcion;

public class ExcepcionFechaIncorrecta extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionFechaIncorrecta(String message) {
		super(message);
	}

}
