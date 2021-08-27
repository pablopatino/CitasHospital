package com.hospitalCitas.hospitalCitas.aplicacion.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;
import com.hospitalCitas.hospitalCitas.dominio.servicio.ServicioDoctores;

@Component
public class ServicioAplicacionDoctor {

	private final ServicioDoctores servicioDoctores;
	
	@Autowired
	public ServicioAplicacionDoctor(ServicioDoctores servicioDoctores) {
		this.servicioDoctores = servicioDoctores;
	}
	
	public Doctores guardarDoctores(Doctores doctor) {
		return this.servicioDoctores.guardarDoctores(doctor);
	}
	
	public Doctores getDoctores(Long id) {
		return this.servicioDoctores.obtenerDoctorPorId(id);
	}
	
	
	
}
