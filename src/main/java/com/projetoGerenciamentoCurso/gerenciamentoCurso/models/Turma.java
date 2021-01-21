package com.projetoGerenciamentoCurso.gerenciamentoCurso.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Data
public class Turma implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private Integer idTurma;
	private String anoLetivo;
	private String descricao;
	private Integer numeroVagas;
	private Integer periodoLetivo;
	@OneToMany(mappedBy = "turmas",orphanRemoval = true , cascade = CascadeType.PERSIST)
	@JsonManagedReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Disciplina> disciplinas = new HashSet<>();
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "turma")
	@JsonIgnore
	private Set<Aluno> alunos = new HashSet<>();
	
}
