package com.hospitalCitas.hospitalCitas.dominio.servicio.validaciones;



import org.slf4j.*;
import org.springframework.stereotype.Component;

import com.hospitalCitas.hospitalCitas.dominio.dto.CitaDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.DoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.PacienteDTO;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionValorRequerido;

@Component
public class ValidarCampos {
	
	Logger logger = LoggerFactory.getLogger(ValidarCampos.class);
	private static final String VALOR_REQUERIDO = "VALOR REQUERIDO";
	
	private void validarCampo(Object string) {
		if ( string == null || string.toString().isEmpty()) {
			throw new ExcepcionValorRequerido(VALOR_REQUERIDO);
		}
	}
	
	private void validarTelefono(int numero) {
		final int NUMERO_MAXIMO_TELEFONO = 7;		
		String numeros = String.valueOf(numero);
		char[] arrNum = numeros.toCharArray();
		if (arrNum.length < NUMERO_MAXIMO_TELEFONO) {
			throw new ExcepcionValorRequerido(VALOR_REQUERIDO);
		}
	}
	
	private void validarEspecialidadDoctor(int especialidad) {
		if (especialidad<= 0) {
			throw new ExcepcionValorRequerido(VALOR_REQUERIDO);
		}
	}
		
	private String quitarEspaciosEnBlanco(String str) {
		return str.replaceAll("\\s+", "");
	}
	
	public void validarPaciente(PacienteDTO paciente) {
		String identificador = quitarEspaciosEnBlanco(paciente.getIdentificacionPaciente());
		validarCampo(identificador);
		validarCampo(paciente.getNombrePaciente());
		validarTelefono(paciente.getTelefono());
		paciente.setIdentificacionPaciente(identificador);
	}
	
	public void validarDoctor(DoctorDTO doctor) {
		String identificador = quitarEspaciosEnBlanco(doctor.getIdDoctor());
		validarCampo(identificador);
		validarCampo(doctor.getNombreCompleto());
		validarEspecialidadDoctor(doctor.getEspecialidad());
		doctor.setIdDoctor(identificador);
	}
	
	public void validarCita(CitaDTO cita) {
		validarCampo(cita.getMotivoCita());
		validarCampo(cita.getFechaCita());
	}
	
	public void validarPacienteModificado(PacienteDTO paciente) {
		validarTelefono(paciente.getTelefono());
		validarCampo(paciente.getNombrePaciente());
	}
	

}
