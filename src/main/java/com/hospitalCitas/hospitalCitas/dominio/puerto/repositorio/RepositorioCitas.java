package com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;

public interface RepositorioCitas extends CrudRepository<Cita, Long> {
	
	@Query( value = "SELECT * FROM CITAS WHERE IDENTIFICACION_USUARIO = :identificacionUsuario", nativeQuery = true)
	public List<Cita> todasLasCitas(String identificacionUsuario);

}
