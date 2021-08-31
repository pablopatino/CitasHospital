package com.hospitalCitas.hospitalCitas.infrastructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalCitas.hospitalCitas.aplicacion.servicio.ServicioAplicativoCita;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitaCompletaDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitaDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.respuesta.Mensaje;

@RestController
@RequestMapping("/cita")
public class ControladorCitas {

	private final ServicioAplicativoCita servicioAplicativoCita;

	@Autowired
	public ControladorCitas(ServicioAplicativoCita servicioAplicativoCita) {
		this.servicioAplicativoCita = servicioAplicativoCita;
	}

	@PostMapping("/guardar/{idPaciente}")
	public CitaCompletaDTO guardarCita(@RequestBody CitaDTO cita, @PathVariable String idPaciente) {
		return this.servicioAplicativoCita.guardarCita(cita, idPaciente);
	}
	
	@DeleteMapping("/eliminar/{idCita}")
	public ResponseEntity<Mensaje> eliminarCita(@PathVariable Long idCita){
		Mensaje mensaje = new Mensaje("Cita eliminada, correctamente");
		this.servicioAplicativoCita.eliminarCita(idCita);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
	}

}
