package com.hospitalCitas.hospitalCitas.dominio.excepcion;

public class ExcepcionRepetido extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionRepetido(String message) {
		super(message);
	}

}
