package com.hospitalCitas.hospitalCitas.dominio.dto;

public class CitasDoctorDTO {

	private String identificacionCita;
	private String motivoCita;
	private String observaciones;
	private String fechaCita;
	private String identificacionPaciente;
	private String nombrePaciente;
	private int telefonoPaciente;
	
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
	public int getTelefonoPaciente() {
		return telefonoPaciente;
	}
	public void setTelefonoPaciente(int telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}

	
	
}
