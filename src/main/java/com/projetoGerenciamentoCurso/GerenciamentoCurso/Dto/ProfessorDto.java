package com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Disciplina;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Pessoa;

import lombok.Data;

@Data
public class ProfessorDto extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private Integer idProfessor;
	
	private String titulacao;
	
	private Disciplina disciplina;
}
