package com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;

public interface RepositorioCitas extends CrudRepository<Cita, Long> {
	
	@Query( value = "SELECT * FROM CITAS WHERE PACIENTES_IDENTIFICACION_PACIENTE = :idPaciente", nativeQuery = true)
	public List<Cita> todasLasCitas(String idPaciente);
	
	@Query( value = "SELECT * FROM CITAS WHERE DOCTOR_ID = :idDoctor", nativeQuery = true)
	public List<Cita> todasLasCitasDelDoctor(Long idDoctor);

}
