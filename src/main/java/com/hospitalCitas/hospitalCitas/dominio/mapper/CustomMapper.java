package com.hospitalCitas.hospitalCitas.dominio.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitaCompletaDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitasDoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitasPacientesDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.DoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.PacienteDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Paciente;

@Component
public class CustomMapper {

	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
		
	public PacienteDTO pacienteToDTO(Paciente paciente, int citasTotales) {
		PacienteDTO pacienteDTO = modelMapper().map(paciente, PacienteDTO.class);			
		pacienteDTO.setCitasTotales(citasTotales);
		return pacienteDTO;
	}
	
	
	public DoctorDTO doctorToDTO(Doctores doctor) {
		return modelMapper().map(doctor, DoctorDTO.class);	
	}

	public CitaCompletaDTO citaCompletaToDTO(Paciente paciente, Cita cita, Doctores doctores) {
		CitaCompletaDTO citaCompletaDTO = modelMapper().map(cita, CitaCompletaDTO.class);
			citaCompletaDTO.setNombreDelDoctor(doctores.getNombreCompleto());
			citaCompletaDTO.setEspecialidadDelDoctor(doctores.getEspecialidad());
			citaCompletaDTO.setIdentificacionPaciente(paciente.getIdentificacionPaciente());
			citaCompletaDTO.setNombreDelPaciente(paciente.getNombrePaciente());
			citaCompletaDTO.setTelefono(paciente.getTelefono());
		return citaCompletaDTO;
	}
	
	public CitasPacientesDTO citasPacientesToDTO(Cita cita, String nombreDoctor) {	
		CitasPacientesDTO citasDoctorDTO = modelMapper().map(cita, CitasPacientesDTO.class);
		citasDoctorDTO.setNombreDelDoctor(nombreDoctor);	
		return citasDoctorDTO;
		
	}
	
	public CitasDoctorDTO citasDoctorToDTO(Cita cita, Paciente paciente) {	
		CitasDoctorDTO citasDoctorDTO = modelMapper().map(cita, CitasDoctorDTO.class);	
		citasDoctorDTO.setNombrePaciente(paciente.getNombrePaciente());
		citasDoctorDTO.setIdentificacionPaciente(paciente.getIdentificacionPaciente());
		citasDoctorDTO.setTelefonoPaciente(paciente.getTelefono());	
		return citasDoctorDTO;
		
	}
	

	
	
	
}
