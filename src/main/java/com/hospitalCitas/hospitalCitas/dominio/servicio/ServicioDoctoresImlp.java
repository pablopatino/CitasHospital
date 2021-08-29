package com.hospitalCitas.hospitalCitas.dominio.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitasDoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.DoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionNotFound;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionRepetido;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionValorRequerido;
import com.hospitalCitas.hospitalCitas.dominio.mapper.CustomMapper;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Paciente;
import com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio.RepositorioCitas;
import com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio.RepositorioDoctores;
import com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio.RepositorioPaciente;
import com.hospitalCitas.hospitalCitas.dominio.servicio.validaciones.ValidarCampos;

@Service
public class ServicioDoctoresImlp implements ServicioDoctores {

	private static final String REPETIDO = "Doctor Repetido";
	private static final String NOT_FOUND = "NOT FOUND";
	private static final String VALOR_REQUERIDO = "Valor Requerido";

	private final RepositorioDoctores repositorioDoctores;
	private final RepositorioCitas repositorioCitas;
	private final RepositorioPaciente repositorioPaciente;

	@Autowired
	private CustomMapper mapper;
	@Autowired
	private ValidarCampos validarCampos;
	

	@Autowired
	public ServicioDoctoresImlp(RepositorioDoctores repositorioDoctores, RepositorioCitas repositorioCitas, RepositorioPaciente repositorioPaciente) {
		this.repositorioDoctores = repositorioDoctores;
		this.repositorioCitas = repositorioCitas;
		this.repositorioPaciente = repositorioPaciente;
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	
	@Override
	public DoctorDTO guardarDoctores(Doctores doctor) {
		validarCampos.validarDoctor(doctor);
		validacionDoctores(doctor.getIdDoctor());
		this.repositorioDoctores.save(doctor);
		return mapper.EntityToDTO(doctor);

	}

	@Override
	public Doctores obtenerDoctorPorId(Long idDoctor) {
		return this.repositorioDoctores.findById(idDoctor).orElse(null);
	}

	@Override
	public List<CitasDoctorDTO> getCitasDelDoctor(String idDoctor) {
		validarIdentificadorDoctor(idDoctor);
		return citasDelDoctor(idDoctor);
		
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	
	private void validacionDoctores(String idDoctor) {
		Doctores doctor = this.repositorioDoctores.buscarDoctorPorIdentificacion(idDoctor);
		if (doctor != null) {
			throw new ExcepcionRepetido(REPETIDO);
		}
	}
	
	private void validarIdentificadorDoctor(String idDoctor) {
		if ( idDoctor == null|| idDoctor.isEmpty()) {
			throw new ExcepcionValorRequerido(VALOR_REQUERIDO);
		}
	}

	private List<CitasDoctorDTO> citasDelDoctor(String idDoctor) {
		List<CitasDoctorDTO> citasDoctor = new ArrayList<>();	
		List<Cita> citas = this.repositorioCitas.todasLasCitas(idDoctor);
		
		citas.stream().forEach(cita -> {
			Paciente paciente = this.repositorioPaciente.findById(cita.getIdentificacionUsuario()).orElse(null);
			validarUsuario(paciente);
			CitasDoctorDTO citaDoctorDTO = new CitasDoctorDTO();
			citaDoctorDTO = this.mapper.EntityToDto(cita, paciente);
			citasDoctor.add(citaDoctorDTO);
		});
		
		return citasDoctor;
	}
	
	private void validarUsuario(Paciente paciente) {
		if (paciente == null) {
			throw new ExcepcionNotFound(NOT_FOUND);
		}
	}

}
