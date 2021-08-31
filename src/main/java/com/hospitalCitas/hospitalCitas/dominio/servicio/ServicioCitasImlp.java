package com.hospitalCitas.hospitalCitas.dominio.servicio;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitaCompletaDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitaDTO;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionFechaIncorrecta;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionNotFound;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionRepetido;
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
	private static final String FECHA_INCORRECTA = "Fecha incorrecta";
	private static final String FECHA_YA_UTILIZADA = "FECHA_YA_UTILIZADA";
	private static final String PACIENTE_NO_ENCONTRADO = "Paciente no encontrado";

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
		validarIdPaciente(idPaciente);
		verificarFecha(cita.getFechaCita());
		verificarFechaNoRepetida(cita.getFechaCita());

		Doctores docs = validarEstadoDelDoctor();
		Paciente paciente = this.repositorioPaciente.buscarPacientePorIdentificacion(idPaciente);

		Cita persisCita = new Cita(null, cita.getMotivoCita(), cita.getObservaciones(), cita.getFechaCita(), paciente,
				docs);

		persisCita.setDoctor(docs);
		persisCita.setPacientes(paciente);

		this.repositorioCitas.save(persisCita);

		return customMapper.citaCompletaToDTO(paciente, persisCita, docs);
	}

	// ------------------------------------------------------------------------------------------------------------------//

	private Doctores validarEstadoDelDoctor() {
		Doctores docs = this.repositorioDoctores.trearDosctorRandom();
		if (!docs.isActivo()) {
			return validarEstadoDelDoctor();
		} else {
			return docs;
		}
	}

	private void verificarFecha(String fecha) {
		int revisarFecha = 0;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaActual = new Date();
		try {
			Date fecDate = format.parse(fecha);
			revisarFecha = fechaActual.compareTo(fecDate);
		} catch (Exception e) {
			e.getMessage();
		}
		if (revisarFecha == 1) {
			throw new ExcepcionFechaIncorrecta(FECHA_INCORRECTA);
		}
	}

	private void verificarFechaNoRepetida(String fecha) {
		Cita cita = this.repositorioCitas.verificarFechaCita(fecha);
		if (cita != null) {
			throw new ExcepcionRepetido(FECHA_YA_UTILIZADA);
		}
	}
	
	private void validarIdPaciente(String id) {
		Paciente paciente = this.repositorioPaciente.buscarPacientePorIdentificacion(id);
		if (paciente != null) {
			throw new ExcepcionNotFound(PACIENTE_NO_ENCONTRADO);
		}
	}

}
