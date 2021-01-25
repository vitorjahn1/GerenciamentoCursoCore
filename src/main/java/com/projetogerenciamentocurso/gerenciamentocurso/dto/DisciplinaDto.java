package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import java.util.HashSet;
import java.util.Set;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Professor;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Turma;

import lombok.Data;
@Data
public class DisciplinaDto {

	private Integer idDisciplina;
	
	private String descricao;
	
	private String cargaHoraria;
	
	private String sigla;
	
	private Turma turmas;

	private Set<Professor> professores = new HashSet<>();

}
