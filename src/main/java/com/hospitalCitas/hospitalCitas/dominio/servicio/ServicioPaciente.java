package com.hospitalCitas.hospitalCitas.dominio.servicio;

import java.util.List;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitasPacientesDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.PacienteDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Paciente;

public interface ServicioPaciente {

	public PacienteDTO guardarPaciente(Paciente paciente);
	public Paciente busacrPorId(String id);
	public List<CitasPacientesDTO> todasLasCitas(String id);
	
	
}
