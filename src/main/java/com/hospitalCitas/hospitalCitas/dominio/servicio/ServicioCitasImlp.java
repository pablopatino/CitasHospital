package com.hospitalCitas.hospitalCitas.dominio.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitaCompletaDTO;
import com.hospitalCitas.hospitalCitas.dominio.mapper.CustomMapper;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Paciente;
import com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio.RepositorioCitas;
import com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio.RepositorioDoctores;
import com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio.RepositorioPaciente;
import com.hospitalCitas.hospitalCitas.dominio.servicio.validaciones.ValidarCampos;


@Service
public class ServicioCitasImlp implements ServicioCitas {

	private final RepositorioCitas repositorioCitas;
	private final RepositorioDoctores repositorioDoctores;
	private final RepositorioPaciente repositorioPaciente;
	
	@Autowired
	private CustomMapper customMapper;
	@Autowired
	private ValidarCampos validarCampos;

	@Autowired
	public ServicioCitasImlp(RepositorioCitas repositorioCitas, RepositorioDoctores repositorioDoctores,
			RepositorioPaciente repositorioPaciente) {
		this.repositorioCitas = repositorioCitas;
		this.repositorioDoctores = repositorioDoctores;
		this.repositorioPaciente = repositorioPaciente;
	}

	@Override
	public CitaCompletaDTO guardarCita(Cita cita, String idPaciente) {
		validarCampos.validarCita(cita);
		Doctores docs = this.repositorioDoctores.trearDosctorRandom();
		Paciente paciente = this.repositorioPaciente.buscarPacientePorIdentificacion(idPaciente);
		
		cita.setDoctor(docs);
		cita.setPacientes(paciente);


		this.repositorioCitas.save(cita);

		return customMapper.EntityToDto(paciente, cita, docs);
	}
	

}
