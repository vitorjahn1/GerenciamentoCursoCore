package com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto;

import java.util.HashSet;
import java.util.Set;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Professor;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Turma;

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
