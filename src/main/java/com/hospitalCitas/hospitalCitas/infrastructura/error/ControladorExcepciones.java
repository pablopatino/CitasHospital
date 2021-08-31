package com.hospitalCitas.hospitalCitas.infrastructura.error;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionFechaIncorrecta;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionNotFound;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionRepetido;
import com.hospitalCitas.hospitalCitas.dominio.excepcion.ExcepcionValorRequerido;


@ControllerAdvice
public class ControladorExcepciones {

	private static final ConcurrentHashMap<String, Integer> CODIGO_ESTADO = new ConcurrentHashMap<>();
	
	public ControladorExcepciones() {
		CODIGO_ESTADO.put(ExcepcionValorRequerido.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGO_ESTADO.put(ExcepcionRepetido.class.getSimpleName(), HttpStatus.CONFLICT.value());
		CODIGO_ESTADO.put(ExcepcionNotFound.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
		CODIGO_ESTADO.put(ExcepcionFechaIncorrecta.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> allExceptions(Exception exception){
		ResponseEntity<Error> resultado;
		
		String excepcionNombre = exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
		Integer codigo = CODIGO_ESTADO.get(excepcionNombre);
		
		if (codigo != null) {
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
		} else {
            Error error = new Error(excepcionNombre, "Internal server Error");
            
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
		return resultado;
	}
}
