package com.hospitalCitas.hospitalCitas.dominio.dto;

public class CitasPacientesDTO {

	private String identificacionCita;
	private String motivoCita;
	private String observaciones;
	private String fechaCita;
	private String NombreDelDoctor;

	public String getIdentificacionCita() {
		return identificacionCita;
	}

	public void setIdentificacionCita(String identificacionCita) {
		this.identificacionCita = identificacionCita;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getNombreDelDoctor() {
		return NombreDelDoctor;
	}

	public void setNombreDelDoctor(String nombreDelDoctor) {
		NombreDelDoctor = nombreDelDoctor;
	}

}
