package com.hospitalCitas.hospitalCitas.aplicacion.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitaCompletaDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;
import com.hospitalCitas.hospitalCitas.dominio.servicio.ServicioCitas;

@Component
public class ServicioAplicativoCita {

	private final ServicioCitas servicioCitas;

	@Autowired
	public ServicioAplicativoCita(ServicioCitas servicioCitas) {
		this.servicioCitas = servicioCitas;
	}
	
	
	public CitaCompletaDTO guardarCita(Cita cita) {
		return this.servicioCitas.guardarCita(cita);
	}
	
	
}
