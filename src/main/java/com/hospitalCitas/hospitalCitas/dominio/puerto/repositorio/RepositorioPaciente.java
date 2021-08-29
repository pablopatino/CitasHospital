package com.hospitalCitas.hospitalCitas.dominio.puerto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hospitalCitas.hospitalCitas.dominio.modelo.Cita;
import com.hospitalCitas.hospitalCitas.dominio.modelo.Paciente;

public interface RepositorioPaciente extends CrudRepository<Paciente, String> {

	@Query("SELECT p from Paciente p WHERE p.identificacionPaciente = :identificacionPaciente")
	public Paciente buscarPacientePorIdentificacion(String identificacionPaciente);

	@Query("SELECT p.citas FROM Paciente p WHERE p.identificacionPaciente = :identificacionPaciente")
	public List<Cita> citasDelUsuario(String identificacionPaciente);
	
	@Query( value = "SELECT * FROM CITAS WHERE IDENTIFICACION_USUARIO = :identificacionUsuario", nativeQuery = true)
	public List<Cita> todasLasCitas(String identificacionUsuario);

	@Query( value = "SELECT COUNT(PACIENTES_IDENTIFICACION_PACIENTE) FROM CITAS WHERE PACIENTES_IDENTIFICACION_PACIENTE = :identificacionUsuario ", nativeQuery = true)
	public int citasTotalesDelPaciente(String identificacionUsuario);
	
}
