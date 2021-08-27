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
}
