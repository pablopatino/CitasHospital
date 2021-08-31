package com.hospitalCitas.hospitalCitas.dominio.dto;

public class DoctorDTO {

	private String idDoctor;
	private String nombreCompleto;
	private int especialidad;
	private boolean activo;
	
	
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(String idDoctor) {
		this.idDoctor = idDoctor;
	}
	
	
}
