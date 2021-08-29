package com.hospitalCitas.hospitalCitas.dominio.servicio;

import java.util.List;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitasDoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.DoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;

public interface ServicioDoctores {

	public DoctorDTO guardarDoctores(Doctores doctor);
	public Doctores obtenerDoctorPorId(Long idDoctor);
	
	public List<CitasDoctorDTO> getCitasDelDoctor(String idDoctor);
}
