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
import com.hospitalCitas.hospitalCitas.dominio.modelo.busquedas.BusquedaIndentificador;
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
	public ServicioDoctoresImlp(RepositorioDoctores repositorioDoctores, RepositorioCitas repositorioCitas,
			RepositorioPaciente repositorioPaciente) {
		this.repositorioDoctores = repositorioDoctores;
		this.repositorioCitas = repositorioCitas;
		this.repositorioPaciente = repositorioPaciente;
	}

	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

	@Override
	public DoctorDTO guardarDoctores(DoctorDTO doctor) {

		validarCampos.validarDoctor(doctor);
		validarDoctorRepetido(doctor.getIdDoctor());
		validarSiDoctoresTienenElMismoNombre(doctor.getNombreCompleto());
		Doctores persisDoctor = new Doctores(doctor.getIdDoctor(), doctor.getNombreCompleto(), doctor.getEspecialidad(),
				doctor.isActivo());
		this.repositorioDoctores.save(persisDoctor);
		return mapper.doctorToDTO(persisDoctor);

	}

	@Override
	public DoctorDTO obtenerDoctorPorId(String idDoctor) {
		validarIdentificadorDoctor(idDoctor);
		validarDoctorPorId(idDoctor);
		Doctores doctor = this.repositorioDoctores.buscarDoctorPorIdentificacion(idDoctor);
		return this.mapper.doctorToDTO(doctor);
	}

	@Override
	public List<CitasDoctorDTO> getCitasDelDoctor(String nombreDelDoctor) {
		validarDoctorExistePorNombre(nombreDelDoctor);

		return citasDelDoctor(nombreDelDoctor);

	}

	@Override
	public void cambioDeEstadoDelDoctor(BusquedaIndentificador busquedaIndentificador) {

		Doctores doctorBD = this.repositorioDoctores
				.buscarDoctorPorIdentificacion(busquedaIndentificador.getIdentificador());
		doctorBD.setActivo(!doctorBD.isActivo());
		this.repositorioDoctores.save(doctorBD);

	}

	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

	private void validarDoctorRepetido(String idDoctor) {
		Doctores doctor = this.repositorioDoctores.buscarDoctorPorIdentificacion(idDoctor);
		if (doctor != null) {
			throw new ExcepcionRepetido(REPETIDO);
		}
	}

	private void validarIdentificadorDoctor(String idDoctor) {
		if (idDoctor == null || idDoctor.isEmpty()) {
			throw new ExcepcionValorRequerido(VALOR_REQUERIDO);
		}
	}

	private List<CitasDoctorDTO> citasDelDoctor(String nombreDoctor) {
		List<CitasDoctorDTO> citasDoctor = new ArrayList<>();

		validarDoctorExistePorNombre(nombreDoctor);
		Doctores doctor = this.repositorioDoctores.buscarDoctorPorNombreCompleto(nombreDoctor);

		List<Cita> citas = this.repositorioCitas.todasLasCitasDelDoctor(doctor.getId());

		citas.stream().forEach(cita -> {
			Paciente paciente = this.repositorioPaciente.findById(cita.getPacientes().getIdentificacionPaciente())
					.orElse(null);
			validarUsuario(paciente);
			CitasDoctorDTO citaDoctorDTO = new CitasDoctorDTO();
			citaDoctorDTO = this.mapper.citasDoctorToDTO(cita, paciente);
			citasDoctor.add(citaDoctorDTO);
		});

		return citasDoctor;
	}

	private void validarUsuario(Paciente paciente) {
		if (paciente == null) {
			throw new ExcepcionNotFound(NOT_FOUND);
		}
	}

	private void validarSiDoctoresTienenElMismoNombre(String nombre) {
		Doctores doctor = this.repositorioDoctores.buscarDoctorPorNombreCompleto(nombre);
		if (doctor != null) {
			throw new ExcepcionRepetido(REPETIDO);
		}
	}

	private void validarDoctorExistePorNombre(String nombre) {
		Doctores doctor = this.repositorioDoctores.buscarDoctorPorNombreCompleto(nombre);
		if (doctor == null) {
			throw new ExcepcionNotFound(NOT_FOUND);
		}
	}

	private void validarDoctorPorId(String id) {
		Doctores doctor = this.repositorioDoctores.buscarDoctorPorIdentificacion(id);
		if (doctor == null) {
			throw new ExcepcionNotFound(NOT_FOUND);
		}
	}

}
