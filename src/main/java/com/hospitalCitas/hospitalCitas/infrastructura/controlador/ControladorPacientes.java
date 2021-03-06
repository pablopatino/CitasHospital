package com.hospitalCitas.hospitalCitas.infrastructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalCitas.hospitalCitas.aplicacion.servicio.ServicioAplicacionPaciente;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitasPacientesDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.PacienteDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.respuesta.Mensaje;

@RestController
@RequestMapping("/pacientes")
public class ControladorPacientes {

	private final ServicioAplicacionPaciente servicioAplicacionPaciente;

	@Autowired
	public ControladorPacientes(ServicioAplicacionPaciente servicioAplicacionPaciente) {
		this.servicioAplicacionPaciente = servicioAplicacionPaciente;
	}

	@PostMapping("/guardar")
	public ResponseEntity<PacienteDTO> guardarPaciente(@RequestBody PacienteDTO paciente) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.servicioAplicacionPaciente.guardarPaciente(paciente));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.servicioAplicacionPaciente.getPaciente(id));
	}

	@GetMapping("/getall/{id}")
	public List<CitasPacientesDTO> buscarTodasLasCitas(@PathVariable String id) {
		return this.servicioAplicacionPaciente.getAllCitas(id);
	}

	@PutMapping("/modificar/{id}")
	public ResponseEntity<Mensaje> modifucarPaciente(@RequestBody PacienteDTO paciente, @PathVariable String id) {
		Mensaje mensaje = new Mensaje("Paciente modificado correctamente");
		this.servicioAplicacionPaciente.modificarPaciente(paciente, id);
		return ResponseEntity.status(HttpStatus.OK).body(mensaje);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Mensaje> eliminarPaciente(@PathVariable String id) {
		Mensaje mensaje = new Mensaje("Eliminado Correctamente");
		this.servicioAplicacionPaciente.eliminarPaciente(id);
		return ResponseEntity.status(HttpStatus.OK).body(mensaje);
	}

}
