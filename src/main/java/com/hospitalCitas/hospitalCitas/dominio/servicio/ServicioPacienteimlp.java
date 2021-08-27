package com.hospitalCitas.hospitalCitas.dominio.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitasPacientesDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.PacienteDTO;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionNotFound;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionRepetido;
import com.hospitalCitas.hospitalCitas.dominio.mapper.CustomMapper;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Paciente;
import com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio.RepositorioCitas;
import com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio.RepositorioPaciente;

@Service
public class ServicioPacienteimlp implements ServicioPaciente {

	private static final String USUARIO_EXISTE = "Usuario ya esta registrado";
	private static final String NOT_FOUND = "NOT FOUND";

	private final RepositorioPaciente repositorioPaciente;
	private final RepositorioCitas repositorioCitas;

	@Autowired
	private CustomMapper customMapper;

	@Autowired
	public ServicioPacienteimlp(RepositorioPaciente repositorioPaciente, RepositorioCitas repositorioCitas) {
		this.repositorioPaciente = repositorioPaciente;
		this.repositorioCitas = repositorioCitas;
	}

	@Override
	public PacienteDTO guardarPaciente(Paciente paciente) {
		verificarPacienteNoRepetido(paciente.getIdentificacionPaciente());
		 this.repositorioPaciente.save(paciente);
		 return customMapper.EntityToMap(paciente);
	}

	@Override
	public Paciente busacrPorId(String id) {
		verificarUsuarioExiste(id);
		return this.repositorioPaciente.findById(id).orElse(null);
	}

	@Override
	public List<CitasPacientesDTO> todasLasCitas(String id) {
		verificarUsuarioExiste(id);
		validarCitas(id);
		return convertirDeEntityaDTO(id);
	}

	private void verificarPacienteNoRepetido(String identificacionPaciente) {
		Paciente paciente = buscarPacientePorIdentificacion(identificacionPaciente);
		if (paciente != null) {
			throw new ExcepcionRepetido(USUARIO_EXISTE);
		}
	}

	private Paciente buscarPacientePorIdentificacion(String identificacionPaciente) {
		Paciente paciente = this.repositorioPaciente.findById(identificacionPaciente).orElse(null);
		return paciente;
	}

	private List<CitasPacientesDTO> convertirDeEntityaDTO(String id) {
		List<CitasPacientesDTO> citasDTO = new ArrayList<>();
		List<Cita> citas = this.repositorioCitas.todasLasCitas(id);

		citas.stream().forEach(cita -> {
			CitasPacientesDTO citaDto = new CitasPacientesDTO();
			citaDto = this.customMapper.EntitToDTO(cita, cita.getNombreDelDoctor());
			citasDTO.add(citaDto);
		});

		return citasDTO;

	}
	
	private void verificarUsuarioExiste(String id) {
		Paciente paciente = buscarPacientePorIdentificacion(id);
		if (paciente == null) {
			throw new ExcepcionNotFound(NOT_FOUND);
		}
	}
	
	private void validarCitas(String id) {
		List<Cita> citas = this.repositorioCitas.todasLasCitas(id);
		if (citas.isEmpty()) {
			throw new ExcepcionNotFound(NOT_FOUND);
		}
		
	}

}
