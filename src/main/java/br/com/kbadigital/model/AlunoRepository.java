package br.com.kbadigital.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @autor Katarine Albuquerque
 * @version 1.0
 * Repositório de Alunos
 * */

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
	// Repositório de Alunos
}
