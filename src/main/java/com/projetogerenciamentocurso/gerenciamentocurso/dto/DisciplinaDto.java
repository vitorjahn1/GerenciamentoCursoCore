package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDto implements Serializable{

	private static final long serialVersionUID = -8220449798980662607L;
	@Id
	private Integer idDisciplina;
	
	private String descricao;
	
	private String cargaHoraria;
	
	private String sigla;
	
	private ProfessorDto professor;

}
