package br.com.kbadigital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kbadigital.model.Curso;
import br.com.kbadigital.model.CursoRepository;
import br.com.kbadigital.service.CursoService;

/**
 * @author Katarine Albuquerque
 * @Version 1.0
 * Service de Curso
 * */

@Service
public class CursoImpl implements CursoService {
	
	// Dependências
	@Autowired
	private CursoRepository cursoRepository;

	// Inserir Curso
	@Override
	public void inserir(Curso obj) {		
		cursoRepository.save(obj);
	}

	// Busca o Id do Curso, se existir atualiza, se não lança uma exceção.
	@Override
	public void atualizar(Long id, Curso obj) {
		Curso cursoBd = cursoRepository.findById(id).get();
		if(cursoBd != null) {
			cursoRepository.save(obj);
		} else {
			throw new IllegalStateException("Não há curso com esse Id!");
		}
	}

	// Deletar Curso
	@Override
	public void apagar(Long id) {
		cursoRepository.deleteById(id);
	}

	// Lista Curso por Id
	@Override
	public Curso listarPorId(Long id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.get();
	}

	// Lista todos os Cursos
	@Override
	public List<Curso> listarTodos() {
		List<Curso> cursos = (List<Curso>) cursoRepository.findAll();
		return cursos;
	} 
}
