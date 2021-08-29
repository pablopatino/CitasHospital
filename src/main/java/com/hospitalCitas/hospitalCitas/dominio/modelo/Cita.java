package com.hospitalCitas.hospitalCitas.dominio.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "citas")
public class Cita {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String identificacionCita;
	private String motivoCita;
	private String observaciones;
	private String fechaCita;
	private String identificacionUsuario;
	private String nombreDelDoctor;
	@OneToOne(fetch = FetchType.LAZY)
	private Doctores doctor;
	@OneToOne(fetch = FetchType.LAZY)
	private Paciente pacientes;
	

	public Cita() {

	}

	public Cita(String identificacionCita, String motivoCita, String observaciones, String fechaCita,
			String identificacionUsuario, String nombreDelDoctor, Paciente pacientes, Doctores doctor) {

		this.identificacionCita = identificacionCita;
		this.motivoCita = motivoCita;
		this.observaciones = observaciones;
		this.fechaCita = fechaCita;
		this.identificacionUsuario = identificacionUsuario;
		this.nombreDelDoctor = nombreDelDoctor;
		this.pacientes = pacientes;
		this.doctor = doctor;
	}

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

	public Paciente getPacientes() {
		return pacientes;
	}

	public void setPacientes(Paciente pacientes) {
		this.pacientes = pacientes;
	}

	public Doctores getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctores doctor) {
		this.doctor = doctor;
	}

	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}

	public void setIdentificacionUsuario(String identificacionUsuario) {
		this.identificacionUsuario = identificacionUsuario;
	}

	public String getNombreDelDoctor() {
		return nombreDelDoctor;
	}

	public void setNombreDelDoctor(String nombreDelDoctor) {
		this.nombreDelDoctor = nombreDelDoctor;
	}

}
