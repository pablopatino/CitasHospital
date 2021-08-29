package com.hospitalCitas.hospitalCitas.dominio.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctores")
public class Doctores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String idDoctor;
	private String nombreCompleto;
	private int especialidad;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor" , cascade = CascadeType.ALL)
	private List<Cita> citas;
	private boolean activo;
	
	public Doctores(){
		this.citas = new ArrayList<>();
	}

	public Doctores(String idDoctor, String nombreCompleto, int especialidad, List<Cita> citas, boolean activo) {
				
		this.idDoctor = idDoctor;
		this.nombreCompleto = nombreCompleto;
		this.especialidad = especialidad;
		this.citas = new ArrayList<>();
		this.activo = activo;
	}

	public String getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(String idDoctor) {
		this.idDoctor = idDoctor;
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

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
