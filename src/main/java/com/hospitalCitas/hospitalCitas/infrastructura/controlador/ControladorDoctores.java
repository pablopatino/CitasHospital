package com.hospitalCitas.hospitalCitas.infrastructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalCitas.hospitalCitas.aplicacion.servicio.ServicioAplicacionDoctor;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;

@RestController
@RequestMapping("/doctores")
public class ControladorDoctores {

	
	private final ServicioAplicacionDoctor servicioAplicacionDoctor;

	@Autowired
	public ControladorDoctores(ServicioAplicacionDoctor servicioAplicacionDoctor) {
		this.servicioAplicacionDoctor = servicioAplicacionDoctor;
	}
	
	@PostMapping("/guardar")
	public Doctores guardarDoctores(@RequestBody Doctores doctor) {
		return this.servicioAplicacionDoctor.guardarDoctores(doctor);
	}
	
	@GetMapping("/buscar/{id}")
	public Doctores buscarPorId(@PathVariable Long id) {
		return this.servicioAplicacionDoctor.getDoctores(id);
	}
	
}
