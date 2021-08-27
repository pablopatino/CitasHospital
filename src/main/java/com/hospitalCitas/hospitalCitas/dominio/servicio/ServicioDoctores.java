package com.hospitalCitas.hospitalCitas.dominio.servicio;

import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;

public interface ServicioDoctores {

	public Doctores guardarDoctores(Doctores doctor);
	public Doctores obtenerDoctorPorId(Long idDoctor);
}
