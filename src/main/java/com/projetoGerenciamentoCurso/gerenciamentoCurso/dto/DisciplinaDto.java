package com.projetoGerenciamentoCurso.gerenciamentoCurso.dto;

import java.util.HashSet;
import java.util.Set;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Professor;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Turma;

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
