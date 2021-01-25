package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Disciplina;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Pessoa;

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
