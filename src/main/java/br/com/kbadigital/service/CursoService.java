package br.com.kbadigital.service;

import java.util.List;

import br.com.kbadigital.model.Curso;

/**
 * @author Katarine Albuquerque
 * @Version 1.0
 * Interface Curso Service
 * */

public interface CursoService {
	void inserir(Curso obj);
	void atualizar(Long id, Curso obj);
	void apagar(Long id);
	Curso listarPorId(Long id);
	List<Curso> listarTodos();
}
