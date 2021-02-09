package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;


@Data
public class TurmaDto implements Serializable{
	
	private static final long serialVersionUID = 1163091750281931L;

	private Integer idTurma;
	
	private String anoLetivo;
	
	private String descricao;
	
	private Integer numeroVagas;
	
	private Integer periodoLetivo;

	private Set<DisciplinaDto> disciplinas = new HashSet<>();
	
	private Set<AlunoDto> alunos = new HashSet<>();
}
