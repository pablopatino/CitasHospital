package com.hospitalCitas.hospitalCitas.dominio.excepcion;

public class ExcepcionValorRequerido extends RuntimeException {

	public ExcepcionValorRequerido(String mensaje) {
		super(mensaje);
	}
	
	private static final long serialVersionUID = 1L;

}
