package com.hospitalCitas.hospitalCitas.aplicacion.servicio;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitasPacientesDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.PacienteDTO;
import com.hospitalCitas.hospitalCitas.dominio.servicio.ServicioPaciente;

@Component
public class ServicioAplicacionPaciente {

	private final ServicioPaciente servicioPaciente;

	public ServicioAplicacionPaciente(ServicioPaciente servicioPaciente) {
		this.servicioPaciente = servicioPaciente;
	}
	
	public PacienteDTO guardarPaciente(PacienteDTO paciente) {
		return this.servicioPaciente.guardarPaciente(paciente);
	}
	
	public PacienteDTO getPaciente(String id) {
		return this.servicioPaciente.busacrPorId(id);
	}
	
	public List<CitasPacientesDTO> getAllCitas(String id){
		return this.servicioPaciente.todasLasCitas(id);
	}
	public void modificarPaciente(PacienteDTO paciente, String id) {
		this.servicioPaciente.modificarPaciente(paciente, id);
	}
	public void eliminarPaciente(String id) {
		this.servicioPaciente.eliminarPaciente(id);
	}
	
}
