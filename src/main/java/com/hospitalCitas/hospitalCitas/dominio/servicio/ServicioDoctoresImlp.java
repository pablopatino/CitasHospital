package com.hospitalCitas.hospitalCitas.dominio.servicio;

import org.springframework.stereotype.Service;

import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;
import com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio.RepositorioDoctores;

@Service
public class ServicioDoctoresImlp implements ServicioDoctores {

	private final RepositorioDoctores repositorioDoctores;

	public ServicioDoctoresImlp(RepositorioDoctores repositorioDoctores) {
		this.repositorioDoctores = repositorioDoctores;
	}

	@Override
	public Doctores guardarDoctores(Doctores doctor) {
		return this.repositorioDoctores.save(doctor);
	}

	@Override
	public Doctores obtenerDoctorPorId(Long idDoctor) {
		return this.repositorioDoctores.findById(idDoctor).orElse(null);
	}

}
