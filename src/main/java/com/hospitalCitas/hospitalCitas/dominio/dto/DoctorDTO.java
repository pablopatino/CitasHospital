package com.hospitalCitas.hospitalCitas.dominio.dto;

import java.util.ArrayList;
import java.util.List;

public class DoctorDTO {

	private String nombreCompleto;
	private int especialidad;
	private List<CitaDTO> citas;
	
	public DoctorDTO() {
		this.citas = new ArrayList<>(); 
	}

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

	public List<CitaDTO> getCitas() {
		return citas;
	}

	public void setCitas(List<CitaDTO> citas) {
		this.citas = citas;
	}
	
	

}
