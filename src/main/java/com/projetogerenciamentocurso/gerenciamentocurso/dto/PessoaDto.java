package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;
@Data
public class PessoaDto implements Serializable{
	
	private static final long serialVersionUID = 1280865943175337153L;
	@Id 
	private Integer idPessoa;
	private String nome;
	private String cpf;
	private String email;
}
