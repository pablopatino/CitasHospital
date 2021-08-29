package com.hospitalCitas.hospitalCitas.infrastructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<?> guardarDoctor(@RequestBody Doctores doctor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.servicioAplicacionDoctor.guardarDoctores(doctor));
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> getDoctorPorId(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.servicioAplicacionDoctor.getDoctores(id));
	}
	
	@GetMapping("/getall/{nombre}")
	public ResponseEntity<?> getCitasDelDoctor(@PathVariable String nombre){
		return ResponseEntity.status(HttpStatus.OK).body(this.servicioAplicacionDoctor.getCitasDelDoctor(nombre));
	}
	
}
