package com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto;

import java.util.HashSet;
import java.util.Set;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Pessoa;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Turma;

import lombok.Data;

@Data
public class AlunoDto extends Pessoa{

	private static final long serialVersionUID = 1L;

	private Integer matricula;

	private String formaIngresso;

	private Set<Turma> turma = new HashSet<>();

}
