package com.hospitalCitas.hospitalCitas.aplicacion.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitasDoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.DoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;
import com.hospitalCitas.hospitalCitas.dominio.servicio.ServicioDoctores;

@Component
public class ServicioAplicacionDoctor {

	private final ServicioDoctores servicioDoctores;
	
	@Autowired
	public ServicioAplicacionDoctor(ServicioDoctores servicioDoctores) {
		this.servicioDoctores = servicioDoctores;
	}
	
	public DoctorDTO guardarDoctores(Doctores doctor) {
		return this.servicioDoctores.guardarDoctores(doctor);
	}
	
	public DoctorDTO getDoctores(String id) {
		return this.servicioDoctores.obtenerDoctorPorId(id);
	}
	
	public List<CitasDoctorDTO> getCitasDelDoctor(String id){
		return this.servicioDoctores.getCitasDelDoctor(id);
	}
	
	
	
}
