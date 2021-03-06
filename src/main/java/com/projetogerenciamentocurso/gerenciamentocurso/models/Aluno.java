package com.projetogerenciamentocurso.gerenciamentocurso.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Aluno extends Pessoa implements Serializable{

	private static final long serialVersionUID = -6440400741036979763L;
	private Integer matricula;
	@NotNull
	private String formaIngresso;
	
	public Aluno(Integer idPessoa, String nome, String cpf, String email, String formaIngresso) {
		super(idPessoa, nome, cpf, email);
		this.formaIngresso = formaIngresso;
	}
}
