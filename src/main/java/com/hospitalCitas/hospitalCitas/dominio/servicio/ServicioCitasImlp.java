package com.hospitalCitas.hospitalCitas.dominio.servicio;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitaCompletaDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitaDTO;
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

	Logger logger = LoggerFactory.getLogger(ServicioCitasImlp.class);
	
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
	public CitaCompletaDTO guardarCita(CitaDTO cita, String idPaciente) {
		
		validarCampos.validarCita(cita);
		randomDate();
		
		Doctores docs = validarEstadoDelDoctor();
		Paciente paciente = this.repositorioPaciente.buscarPacientePorIdentificacion(idPaciente);
		
		Cita persisCita = new Cita(null,cita.getMotivoCita(), cita.getObservaciones(), cita.getFechaCita(), paciente, docs);
		
		persisCita.setDoctor(docs);
		persisCita.setPacientes(paciente);
	
		this.repositorioCitas.save(persisCita);

		return customMapper.citaCompletaToDTO(paciente, persisCita, docs);
	}
	
	//------------------------------------------------------------------------------------------------------------------//
	
	private Doctores validarEstadoDelDoctor() {
		Doctores docs = this.repositorioDoctores.trearDosctorRandom();
		if (!docs.isActivo()) {
			return validarEstadoDelDoctor();
		} else {
			return docs;
		}

	}
	
	private void randomDate() {
		
		LocalDate startDate = LocalDate.now(); //start date
	    long start = startDate.toEpochDay();
	    String i = String.valueOf(start);
	    logger.info(i);

	    LocalDate endDate = LocalDate.of(2022, 12, 12); //end date
	    long end = endDate.toEpochDay();
	    String ie = String.valueOf(end);
	    logger.info(ie);

	    long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
	    String ie2 = String.valueOf(randomEpochDay);
	    	   logger.info(ie2);
	}
	

}
