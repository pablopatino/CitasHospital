package com.hospitalCitas.hospitalCitas.infrastructura.error;

public class Error {

	private String nombreExcepcion;
	private String mensaje;
	
	public Error(String nombreExcepcion, String mensaje) {
		this.nombreExcepcion = nombreExcepcion;
		this.mensaje = mensaje;
	}
	public String getNombreExcepcion() {
		return nombreExcepcion;
	}
	public void setNombreExcepcion(String nombreExcepcion) {
		this.nombreExcepcion = nombreExcepcion;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
	
	
}
