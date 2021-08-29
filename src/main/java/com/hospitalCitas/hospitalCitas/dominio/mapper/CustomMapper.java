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
	
	public DoctorDTO EntityToMap(Doctores doctores) {
		DoctorDTO doctorDTO = modelMapper().map(doctores, DoctorDTO.class);
		
		doctorDTO.setNombreCompleto(doctores.getNombreCompleto());
		doctorDTO.setEspecialidad(doctores.getEspecialidad());
		
		return doctorDTO;
		
	}
	
	public PacienteDTO EntityToMap(Paciente paciente, int citasTotales) {
		
		PacienteDTO pacienteDTO = modelMapper().map(paciente, PacienteDTO.class);	
				
		pacienteDTO.setCitasTotales(citasTotales);
		
		return pacienteDTO;
	}
	
	
	public DoctorDTO EntityToDTO(Doctores doctor) {
		
		DoctorDTO doctorDTO = modelMapper().map(doctor, DoctorDTO.class);	
		
		return doctorDTO;
	}
	
	
	public CitaCompletaDTO EntityToDto(Paciente paciente, Cita cita, Doctores doctores) {
		
		CitaCompletaDTO citaCompletaDTO = modelMapper().map(cita, CitaCompletaDTO.class);
		
		
		citaCompletaDTO.setIdentificacionPaciente(paciente.getIdentificacionPaciente());
		citaCompletaDTO.setNombreDelPaciente(paciente.getNombrePaciente());
		citaCompletaDTO.setTelefono(paciente.getTelefono());
		citaCompletaDTO.setFechaCita(cita.getFechaCita());
		citaCompletaDTO.setIdentificacionCita(cita.getIdentificacionCita());
		citaCompletaDTO.setMotivoCita(cita.getMotivoCita());
		citaCompletaDTO.setObservaciones(cita.getObservaciones());
		citaCompletaDTO.setNombreDelDoctor(doctores.getNombreCompleto());
		citaCompletaDTO.setEspecialidadDelDoctor(doctores.getEspecialidad());
		
		return citaCompletaDTO;
	}
	
	public CitasPacientesDTO EntitToDTO(Cita cita, String nombreDoctor) {
		
		CitasPacientesDTO citasDoctorDTO = modelMapper().map(cita, CitasPacientesDTO.class);
		
		citasDoctorDTO.setIdentificacionCita(cita.getIdentificacionCita());
		citasDoctorDTO.setFechaCita(cita.getFechaCita());
		citasDoctorDTO.setMotivoCita(cita.getMotivoCita());
		citasDoctorDTO.setNombreDelDoctor(nombreDoctor);
		citasDoctorDTO.setObservaciones(cita.getObservaciones());
		
		return citasDoctorDTO;
		
	}
	
	public CitasDoctorDTO EntityToDto(Cita cita, Paciente paciente) {
		
		CitasDoctorDTO citasDoctorDTO = modelMapper().map(cita, CitasDoctorDTO.class);
		
		citasDoctorDTO.setNombrePaciente(paciente.getNombrePaciente());
		citasDoctorDTO.setIdentificacionPaciente(paciente.getIdentificacionPaciente());
		citasDoctorDTO.setTelefonoPaciente(paciente.getTelefono());
		
		
		return citasDoctorDTO;
		
	}
	

	
	
	
}
