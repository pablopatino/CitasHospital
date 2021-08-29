package com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hospitalCitas.hospitalCitas.dominio.modelo.Doctores;

public interface RepositorioDoctores extends CrudRepository<Doctores,Long> {

	
	@Query("SELECT d FROM Doctores d WHERE d.nombreCompleto = :nombreCompleto")
	public Doctores buscarDoctorPorNombreCompleto(String nombreCompleto);
	
	@Query("SELECT d FROM Doctores d WHERE d.idDoctor = :idDoctor")
	public Doctores buscarDoctorPorIdentificacion(String idDoctor);
}
