package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Professor;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Turma;

import lombok.Data;
@Data
public class DisciplinaDto implements Serializable{

	private static final long serialVersionUID = -8220449798980662607L;
	@Id
	private Integer idDisciplina;
	
	private String descricao;
	
	private String cargaHoraria;
	
	private String sigla;
	
	private Turma turmas;

	private Set<Professor> professores = new HashSet<>();

}
