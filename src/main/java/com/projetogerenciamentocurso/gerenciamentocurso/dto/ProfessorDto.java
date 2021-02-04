package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProfessorDto extends PessoaDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idProfessor;
	
	private String titulacao;
	
	private DisciplinaDto disciplina;
}
