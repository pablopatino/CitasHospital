package com.hospitalCitas.hospitalCitas.dominio.dto;

public class PacienteDTO {

	private String identificacionPaciente;
	private String nombrePaciente;
	private int telefono;
	private int citasTotales;

	public String getIdentificacionPaciente() {
		return identificacionPaciente;
	}

	public void setIdentificacionPaciente(String identificacionPaciente) {
		this.identificacionPaciente = identificacionPaciente;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCitasTotales() {
		return citasTotales;
	}

	public void setCitasTotales(int citasTotales) {
		this.citasTotales = citasTotales;
	}
	
	

}
