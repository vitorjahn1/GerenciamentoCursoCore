package com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;
@Data
public class PessoaDtoResposta implements Serializable {
	
	private static final long serialVersionUID = -6879615634527994050L;
	@Id 
	private Integer idPessoa;
	private String nome;
	private String cpf;
	private String email;
}
