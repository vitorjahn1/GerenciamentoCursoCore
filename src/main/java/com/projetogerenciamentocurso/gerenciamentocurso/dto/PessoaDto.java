package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import java.io.Serializable;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
public class PessoaDto implements Serializable{
	
	private static final long serialVersionUID = -4599548274533012052L;
	@Id 
	private Integer idPessoa;
	private String nome;
	private String cpf;
	private String email;
}
