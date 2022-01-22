package br.com.kbadigital.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Katarine Albuquerque
 * @Version 1.0
 * Entidade Aluno
 * */

@Entity
@Table(name="alunos") // Cria a tabela alunos no Banco de Dados
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Gera Id Automático
	private Long Id;
	private String nome;
	private String email;
	
	@ManyToOne // Muitos para Um (Um Curso Contêm Muitos Alunos)
	@JoinColumn(name="ID_CURSO") // Cria e Junta a coluna ID_CURSO
	private Curso curso;	
	
	public Aluno() {
		super();
	}

	public Aluno(Long id, String nome, String email, Curso curso) {
		super();
		Id = id;
		this.nome = nome;
		this.email = email;
		this.curso = curso;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno [Id=" + Id + ", Nome=" + nome + ", Email=" + email + ", Curso=" + curso.getTitulo() + "]";
	}	
}
