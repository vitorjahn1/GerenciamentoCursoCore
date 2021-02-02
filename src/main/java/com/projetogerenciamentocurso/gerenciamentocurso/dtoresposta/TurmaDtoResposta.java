package com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Aluno;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Disciplina;

import lombok.Data;

@Data
public class TurmaDtoResposta implements Serializable{
	
	private static final long serialVersionUID = -6539270749419266599L;

	private Integer idTurma;
	
	private String anoLetivo;
	
	private String descricao;
	
	private Integer numeroVagas;
	
	private Integer periodoLetivo;

	private Set<Disciplina> disciplinas = new HashSet<>();
	
	private Set<Aluno> alunos = new HashSet<>();
}
