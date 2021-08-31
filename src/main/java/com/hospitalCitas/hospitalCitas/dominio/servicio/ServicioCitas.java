package com.hospitalCitas.hospitalCitas.dominio.servicio;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitaCompletaDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitaDTO;


public interface ServicioCitas {

	public CitaCompletaDTO guardarCita(CitaDTO cita, String idPaciente);
	public void eliminarCita(Long idCita);
	
}
