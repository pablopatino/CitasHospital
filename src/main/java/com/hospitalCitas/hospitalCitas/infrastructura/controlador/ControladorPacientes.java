package com.hospitalCitas.hospitalCitas.infrastructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalCitas.hospitalCitas.aplicacion.servicio.ServicioAplicacionPaciente;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitasPacientesDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Paciente;

@RestController
@RequestMapping("/pacientes")
public class ControladorPacientes {

	private final ServicioAplicacionPaciente servicioAplicacionPaciente;

	@Autowired
	public ControladorPacientes(ServicioAplicacionPaciente servicioAplicacionPaciente) {
		this.servicioAplicacionPaciente = servicioAplicacionPaciente;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> guardarPaciente(@RequestBody Paciente paciente) {
		 return ResponseEntity.status(HttpStatus.CREATED).body(this.servicioAplicacionPaciente.guardarPaciente(paciente));
	}
	
	@GetMapping("/buscar/{id}")
	public Paciente buscarPorId(@PathVariable String id) {
		return this.servicioAplicacionPaciente.getPaciente(id);
	}
	
	@GetMapping("/getall/{id}")
	public List<CitasPacientesDTO> buscarTodasLasCitas(@PathVariable String id) {
		return this.servicioAplicacionPaciente.getAllCitas(id);
	}

}
