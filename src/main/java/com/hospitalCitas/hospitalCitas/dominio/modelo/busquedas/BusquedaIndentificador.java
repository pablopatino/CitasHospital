package com.hospitalCitas.hospitalCitas.dominio.modelo.busquedas; //Compila

public class BusquedaIndentificador {

	private String identificador;
	private String nombre;
	
	public BusquedaIndentificador(String identificador, String nombre) {
		this.identificador = identificador;
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
