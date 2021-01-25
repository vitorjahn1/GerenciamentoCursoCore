package com.projetogerenciamentocurso.gerenciamentocurso.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class Professor extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idProfessor;
	private String titulacao;
	@ManyToOne
	@JsonBackReference
	private Disciplina disciplina;

}
