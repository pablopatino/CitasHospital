package com.hospitalCitas.hospitalCitas.dominio.servicio;

import java.util.List;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitasPacientesDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.PacienteDTO;

public interface ServicioPaciente {

	public PacienteDTO guardarPaciente(PacienteDTO paciente);
	public PacienteDTO busacrPorId(String id);
	public List<CitasPacientesDTO> todasLasCitas(String id);
	public void modificarPaciente(PacienteDTO paciente, String id);
	public void eliminarPaciente(String id);
	
	
}
