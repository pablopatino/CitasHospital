package com.hospitalCitas.hospitalCitas.dominio.servicio.validaciones;



import org.slf4j.*;
import org.springframework.stereotype.Component;

import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionValorRequerido;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Paciente;

@Component
public class ValidarCampos {
	
	Logger logger = LoggerFactory.getLogger(ValidarCampos.class);
	private final String VALOR_REQUERIDO = "VALOR REQUERIDO";
	
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
	
	private void validarEstadoDelDoctor(boolean estado) {
		String msg = String.valueOf(estado);
		logger.info(msg);
		if (!(estado != true || estado != false)) {
			throw new ExcepcionValorRequerido(VALOR_REQUERIDO);
		}
	}
	
	private String quitarEspaciosEnBlanco(String str) {
		return str.replaceAll("\\s+", "");
	}
	
	public void validarPaciente(Paciente paciente) {
		String identificador = quitarEspaciosEnBlanco(paciente.getIdentificacionPaciente());
		validarCampo(identificador);
		validarCampo(paciente.getNombrePaciente());
		validarTelefono(paciente.getTelefono());
		paciente.setIdentificacionPaciente(identificador);
	}
	
	public void validarDoctor(Doctores doctor) {
		String identificador = quitarEspaciosEnBlanco(doctor.getIdDoctor());
		validarCampo(identificador);
		validarCampo(doctor.getNombreCompleto());
		validarEspecialidadDoctor(doctor.getEspecialidad());
		validarEstadoDelDoctor(doctor.isActivo());
		doctor.setIdDoctor(identificador);
	}
	
	public void validarCita(Cita cita) {
		String identificador = quitarEspaciosEnBlanco(cita.getIdentificacionCita());
		validarCampo(identificador);
		validarCampo(cita.getMotivoCita());
		validarCampo(cita.getFechaCita());
//		validarCampo(cita.getIdentificacionUsuario());
//		validarCampo(cita.getNombreDelDoctor());
		cita.setIdentificacionCita(identificador);
	}

}
