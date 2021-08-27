package com.hospitalCitas.hospitalCitas.dominio.excepcion;


public class ExcepcionNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionNotFound(String message) {
		super(message);
	}

}
