package com.projetoGerenciamentoCurso.gerenciamentoCurso.dto;

import java.util.HashSet;
import java.util.Set;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Pessoa;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Turma;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AlunoDto extends Pessoa{

	private static final long serialVersionUID = 1L;

	private Integer matricula;

	private String formaIngresso;

	private Set<Turma> turma = new HashSet<>();

}
