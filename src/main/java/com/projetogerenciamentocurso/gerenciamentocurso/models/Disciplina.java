package com.projetogerenciamentocurso.gerenciamentocurso.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Disciplina implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id 
	private Integer idDisciplina;
	private String descricao;
	private String cargaHoraria;
	private String sigla;
	
}
