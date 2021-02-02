package com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Professor;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Turma;

import lombok.Data;

@Data
public class DisciplinaDtoResposta implements Serializable{

	private static final long serialVersionUID = -7924833266144343772L;

	private Integer idDisciplina;
	
	private String descricao;
	
	private String cargaHoraria;
	
	private String sigla;
	
	private Turma turmas;

	private Set<Professor> professores = new HashSet<>();
}
