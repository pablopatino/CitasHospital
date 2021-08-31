package com.hospitalCitas.hospitalCitas.dominio.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
import com.hospitalCitas.hospitalCitas.dominio.servicio.validaciones.ValidarCampos;

@Service
@Transactional
public class ServicioPacienteimlp implements ServicioPaciente {

	private static final String USUARIO_EXISTE = "Usuario ya esta registrado";
	private static final String NOT_FOUND = "NOT FOUND";

	private final RepositorioPaciente repositorioPaciente;
	private final RepositorioCitas repositorioCitas;

	@Autowired
	private CustomMapper customMapper;
	@Autowired
	private ValidarCampos validarCampos;

	@Autowired
	public ServicioPacienteimlp(RepositorioPaciente repositorioPaciente, RepositorioCitas repositorioCitas) {
		this.repositorioPaciente = repositorioPaciente;
		this.repositorioCitas = repositorioCitas;
	}

	// ----------------------------------------------------------------------------------------------------------------------------//

	@Override
	public PacienteDTO guardarPaciente(PacienteDTO paciente) {
		validarCampos.validarPaciente(paciente);
		verificarPacienteNoRepetido(paciente.getIdentificacionPaciente());

		Paciente persisPaciente = new Paciente(paciente.getIdentificacionPaciente(), paciente.getNombrePaciente(),
				paciente.getTelefono());
		this.repositorioPaciente.save(persisPaciente);
		return customMapper.pacienteToDTO(persisPaciente, 0);
	}

	@Override
	public PacienteDTO busacrPorId(String id) {
		verificarUsuarioExiste(id);
		int citasTotales = this.repositorioPaciente.citasTotalesDelPaciente(id);
		Paciente paciente = this.repositorioPaciente.findById(id).orElse(null);
		return customMapper.pacienteToDTO(paciente, citasTotales);
	}

	@Override
	public List<CitasPacientesDTO> todasLasCitas(String id) {
		verificarUsuarioExiste(id);
		validarCitas(id);
		return convertirDeEntityaDTO(id);
	}

	@Override
	public void modificarPaciente(PacienteDTO paciente, String id) {
		validarCampos.validarPacienteModificado(paciente);
		Paciente pacienteBd = verificarUsuarioExiste(id);

		pacienteBd.setTelefono(paciente.getTelefono());

		this.repositorioPaciente.save(pacienteBd);
	}

	@Override
	public void eliminarPaciente(String id) {
		verificarUsuarioExiste(id);
		this.repositorioPaciente.deleteById(id);

	}

	// -----------------------------------------------------------------------------------------------------------------------------//

	private void verificarPacienteNoRepetido(String identificacionPaciente) {
		Paciente paciente = buscarPacientePorIdentificacion(identificacionPaciente);
		if (paciente != null) {
			throw new ExcepcionRepetido(USUARIO_EXISTE);
		}
	}

	private Paciente buscarPacientePorIdentificacion(String identificacionPaciente) {
		return this.repositorioPaciente.findById(identificacionPaciente).orElse(null);
	}

	private List<CitasPacientesDTO> convertirDeEntityaDTO(String id) {
		List<CitasPacientesDTO> citasDTO = new ArrayList<>();

		List<Cita> citas = this.repositorioCitas.todasLasCitas(id);

		citas.stream().forEach(cita -> {
			CitasPacientesDTO citaDto = new CitasPacientesDTO();
			citaDto = this.customMapper.citasPacientesToDTO(cita, cita.getDoctor().getNombreCompleto());
			citasDTO.add(citaDto);
		});

		return citasDTO;

	}

	private Paciente verificarUsuarioExiste(String id) {
		Paciente paciente = buscarPacientePorIdentificacion(id);
		if (paciente == null) {
			throw new ExcepcionNotFound(NOT_FOUND);
		}
		return paciente;
	}

	private void validarCitas(String id) {
		List<Cita> citas = this.repositorioCitas.todasLasCitas(id);
		if (citas.isEmpty()) {
			throw new ExcepcionNotFound(NOT_FOUND);
		}

	}

}
