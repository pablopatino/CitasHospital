package com.hospitalCitas.hospitalCitas.dominio.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable {


	@Id
	private String identificacionPaciente;
	private String nombrePaciente;
	private int telefono;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pacientes")
	private List<Cita> citas;

	public Paciente() {
		this.citas = new ArrayList<>();
	}

	public Paciente(String identificacionPaciente, String nombrePaciente, int telefono) {

		this.identificacionPaciente = identificacionPaciente;
		this.nombrePaciente = nombrePaciente;
		this.telefono = telefono;
		this.citas =  new ArrayList<>();
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	private static final long serialVersionUID = 1L;

}
