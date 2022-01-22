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

import br.com.kbadigital.model.Curso;
import br.com.kbadigital.service.CursoService;

/**
 * @author Katarine Albuquerque
 * @Version 1.0
 * Curso Controller
 * */

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	// Dependência
	@Autowired
	private CursoService cursoService;
	
	// Salvar
	@PostMapping(value="/salvar")
	public ResponseEntity<Curso> inserir(@RequestBody Curso obj) {
		cursoService.inserir(obj);
		return ResponseEntity.ok(obj);
	}
	
	// Atualizar
	@PutMapping(value="/atualizar/{id}")
	public ResponseEntity<Curso> atualizar(@PathVariable("id") Long id, @RequestBody Curso obj) {
		cursoService.atualizar(id, obj);
		return ResponseEntity.ok(obj);
	}
	
	// Deletar por Id
	@DeleteMapping(value="/apagar/{id}")
	public ResponseEntity<Void> apagar(@PathVariable("id") Long id) {
		cursoService.apagar(id);
		return ResponseEntity.ok().build();
	}
	
	// Listar por Id
	@GetMapping(value="/listar/{id}")
	public ResponseEntity<Curso> listarPorId(@PathVariable("id") Long id) {
		Curso curso = cursoService.listarPorId(id);
		return ResponseEntity.ok(curso);
	}
	
	// Listar Todos
	@GetMapping(value="/listar")
	public ResponseEntity<List<Curso>> listarTodos() {
		List<Curso> cursos = cursoService.listarTodos();
		return ResponseEntity.ok(cursos);
	}
}
