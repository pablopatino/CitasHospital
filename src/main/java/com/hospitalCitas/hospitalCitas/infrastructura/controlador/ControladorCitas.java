package com.hospitalCitas.hospitalCitas.infrastructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalCitas.hospitalCitas.aplicacion.servicio.ServicioAplicativoCita;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitaCompletaDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;

@RestController
@RequestMapping("/cita")
public class ControladorCitas {

	private final ServicioAplicativoCita servicioAplicativoCita;

	@Autowired
	public ControladorCitas(ServicioAplicativoCita servicioAplicativoCita) {
		this.servicioAplicativoCita = servicioAplicativoCita;
	}

	@PostMapping("/guardar")
	public CitaCompletaDTO guardarCita(@RequestBody Cita cita) {
		return this.servicioAplicativoCita.guardarCita(cita);
	}

}