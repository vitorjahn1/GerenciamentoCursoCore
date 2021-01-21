package com.projetoGerenciamentoCurso.gerenciamentoCurso.dto;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Disciplina;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Pessoa;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProfessorDto extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private Integer idProfessor;
	
	private String titulacao;
	
	private Disciplina disciplina;
}
