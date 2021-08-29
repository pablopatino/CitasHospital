package com.hospitalCitas.hospitalCitas.dominio.dto;

public class DoctorDTO {

	private String nombreCompleto;
	private int especialidad;
	
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(int especialidad) {
		this.especialidad = especialidad;
	}
}
