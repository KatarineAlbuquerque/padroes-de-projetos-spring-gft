package br.com.kbadigital.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @autor Katarine Albuquerque
 * @version 1.0
 * Repositório de Cursos
 * */

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
	// Repositório de Cursos
}
