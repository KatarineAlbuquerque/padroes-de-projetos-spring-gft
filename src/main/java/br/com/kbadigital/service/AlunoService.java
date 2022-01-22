package br.com.kbadigital.service;

import java.util.List;

import br.com.kbadigital.model.Aluno;

/**
 * @author Katarine Albuquerque
 * @Version 1.0
 * Interface Aluno Service 
 * */

public interface AlunoService {
	void inserir(Aluno obj);
	void atualizar(Long id, Aluno obj);
	void apagar(Long id);
	Aluno listarPorId(Long id);
	List<Aluno> listarTodos();
}
