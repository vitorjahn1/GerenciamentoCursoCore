package com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProfessorDtoResposta extends PessoaDtoResposta implements Serializable{

	private static final long serialVersionUID = -3896106492973904501L;

	private Integer idProfessor;
	
	private String titulacao;
	
}
