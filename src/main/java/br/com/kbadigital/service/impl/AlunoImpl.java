package br.com.kbadigital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kbadigital.model.Aluno;
import br.com.kbadigital.model.AlunoRepository;
import br.com.kbadigital.model.Curso;
import br.com.kbadigital.model.CursoRepository;
import br.com.kbadigital.service.AlunoService;
import br.com.kbadigital.service.CursoService;

/**
 * @author Katarine Albuquerque
 * @Version 1.0
 * Service de Aluno
 * */

@Service
public class AlunoImpl implements AlunoService {
	
	// Dependências
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private CursoService cursoService;
		
	// Inserir Aluno
	@Override
	public void inserir(Aluno obj) {		
		verificarCurso(obj);
	}

	// Busca o Id do Aluno, se existir atualiza, se não lança uma exceção.
	@Override
	public void atualizar(Long id, Aluno obj) {
		Aluno alunoBd = alunoRepository.findById(id).get();
		if(alunoBd != null) {
			verificarCurso(obj);
		} else {
			throw new IllegalStateException("Não há aluno com esse Id!");
		}
	}
	
	// Verifica se há curso, caso sim, o salva no Repositório do Curso
	// Após salvar curso, ele é setado na entidade Aluno
	// Logo depois é salvo no Banco de Dados
	private void verificarCurso(Aluno obj) {
		Long idCurso = obj.getCurso().getId();
		if(idCurso != null) {
			Curso novoCurso = cursoService.listarPorId(idCurso);
			cursoRepository.save(novoCurso);
			obj.setCurso(novoCurso);
		}		
		alunoRepository.save(obj);
	}

	// Deletar Aluno por Id
	@Override
	public void apagar(Long id) {
		alunoRepository.deleteById(id);		
	}

	// Lista Aluno por Id
	@Override
	public Aluno listarPorId(Long id) {
		Optional<Aluno> alunoBd = alunoRepository.findById(id);
		return alunoBd.get();
	}

	// Lista todos os Alunos
	@Override
	public List<Aluno> listarTodos() {
		List<Aluno> alunos = (List<Aluno>) alunoRepository.findAll();
		return alunos;
	}	
}
