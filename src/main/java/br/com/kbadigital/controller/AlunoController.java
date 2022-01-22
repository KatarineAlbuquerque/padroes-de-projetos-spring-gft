package br.com.kbadigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kbadigital.model.Aluno;
import br.com.kbadigital.service.AlunoService;

/**
 * @author Katarine Albuquerque
 * @Version 1.0
 * Aluno Controller
 * */

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	// Dependência	
	@Autowired
	private AlunoService alunoService;
	
	// Salvar
	@PostMapping(value="/salvar")
	public ResponseEntity<Aluno> inserir(@RequestBody Aluno obj) {
		alunoService.inserir(obj);
		return ResponseEntity.ok(obj);
	}
	
	// Atualizar
	@PutMapping(value="/atualizar/{id}")
	public ResponseEntity<Aluno> atualizar(@PathVariable("id") Long id, @RequestBody Aluno obj) {
		alunoService.atualizar(id, obj);
		return ResponseEntity.ok(obj);
	}
	
	// Deletar por Id
	@DeleteMapping(value="/apagar/{id}")
	public ResponseEntity<Void> apagar(@PathVariable("id") Long id) {
		alunoService.apagar(id);
		return ResponseEntity.ok().build();
	}
	
	// Listar por Id
	@GetMapping(value="/listar/{id}")
	public ResponseEntity<Aluno> listarPorId(@PathVariable("id") Long id) {
		Aluno aluno = alunoService.listarPorId(id);
		return ResponseEntity.ok(aluno);
	}
	
	// Listar Todos
	@GetMapping(value="/listar")
	public ResponseEntity<List<Aluno>> listarTodos() {
		List<Aluno> alunos = alunoService.listarTodos();
		return ResponseEntity.ok(alunos);
	}
}
