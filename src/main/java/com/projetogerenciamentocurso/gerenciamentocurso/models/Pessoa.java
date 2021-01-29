package com.projetogerenciamentocurso.gerenciamentocurso.models;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer idPessoa;
	private String nome;
	private String cpf;
	private String email;
}
