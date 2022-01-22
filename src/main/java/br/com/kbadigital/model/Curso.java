package br.com.kbadigital.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Katarine Albuquerque
 * @Version 1.0
 * Entidade Curso
 * */

@Entity
@Table(name="cursos") // Cria a Tabela cursos no Banco de Dados
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Gera Id Automático
	private Long Id;
	private String titulo;
	private Integer cargaHoraria;
	
	@OneToMany // Um para Muitos (Um Curso Contêm Muitos Alunos)
	//@JoinColumn(name="ID_CURSO")
	private List<Aluno> alunos = new ArrayList<>();
	
	public Curso() {
		super();
	}

	public Curso(Long id, String titulo, Integer cargaHoraria) {
		super();
		Id = id;
		this.titulo = titulo;
		this.cargaHoraria = cargaHoraria;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	@Override
	public String toString() {
		return "Curso [Id=" + Id + ", Titulo=" + titulo + ", Carga horária=" + cargaHoraria + "]";
	}
}
