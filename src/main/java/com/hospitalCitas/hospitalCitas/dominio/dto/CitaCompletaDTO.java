package com.hospitalCitas.hospitalCitas.dominio.dto;

public class CitaCompletaDTO {

	private String identificacionCita;
	private String motivoCita;
	private String observaciones;
	private String fechaCita;
	private String nombreDelDoctor;
	private int especialidadDelDoctor;
	private String identificacionPaciente;
	private String nombreDelPaciente;
	private int telefono;

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
		return nombreDelDoctor;
	}
	public void setNombreDelDoctor(String nombreDelDoctor) {
		this.nombreDelDoctor = nombreDelDoctor;
	}
	public int getEspecialidadDelDoctor() {
		return especialidadDelDoctor;
	}
	public void setEspecialidadDelDoctor(int especialidadDelDoctor) {
		this.especialidadDelDoctor = especialidadDelDoctor;
	}
	public String getIdentificacionPaciente() {
		return identificacionPaciente;
	}
	public void setIdentificacionPaciente(String identificacionPaciente) {
		this.identificacionPaciente = identificacionPaciente;
	}
	public String getNombreDelPaciente() {
		return nombreDelPaciente;
	}
	public void setNombreDelPaciente(String nombreDelPaciente) {
		this.nombreDelPaciente = nombreDelPaciente;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	
	
}
