package com.hospitalCitas.hospitalCitas.infrastructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalCitas.hospitalCitas.aplicacion.servicio.ServicioAplicacionDoctor;
import com.hospitalCitas.hospitalCitas.dominio.dto.CitasDoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.dto.DoctorDTO;
import com.hospitalCitas.hospitalCitas.dominio.modelo.busquedas.BusquedaIndentificador;
import com.hospitalCitas.hospitalCitas.dominio.modelo.respuesta.Mensaje;


@RestController
@RequestMapping("/doctores")
public class ControladorDoctores {

	
	private final ServicioAplicacionDoctor servicioAplicacionDoctor;

	@Autowired
	public ControladorDoctores(ServicioAplicacionDoctor servicioAplicacionDoctor) {
		this.servicioAplicacionDoctor = servicioAplicacionDoctor;
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<DoctorDTO> guardarDoctor(@RequestBody DoctorDTO doctor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.servicioAplicacionDoctor.guardarDoctores(doctor));
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<DoctorDTO> getDoctorPorId(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.servicioAplicacionDoctor.getDoctores(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<CitasDoctorDTO>> getCitasDelDoctor(@RequestParam String nombre){
		return ResponseEntity.status(HttpStatus.OK).body(this.servicioAplicacionDoctor.getCitasDelDoctor(nombre));
	}
	
	@PutMapping("/estado")
	public ResponseEntity<com.hospitalCitas.hospitalCitas.dominio.modelo.respuesta.Mensaje> cambiarEstadoDelDoctor(@RequestBody BusquedaIndentificador busquedaIndentificador){
		servicioAplicacionDoctor.cambiarEstadoDelDoctor(busquedaIndentificador);
		Mensaje mensaje=new Mensaje("ACTUALIZADO CORRECATMENTE");
		return ResponseEntity.status(HttpStatus.OK).body(mensaje);
	}
	
}
