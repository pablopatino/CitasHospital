package com.hospitalCitas.hospitalCitas.dominio.servicio;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitaCompletaDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;

public interface ServicioCitas {

	public CitaCompletaDTO guardarCita(Cita cita, String idPaciente);
	
}
