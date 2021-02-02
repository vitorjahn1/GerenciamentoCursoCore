package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Pessoa;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Turma;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AlunoDto extends Pessoa{

	private static final long serialVersionUID = 1499231588972071898L;

	@Id
	private Integer matricula;

	private String formaIngresso;

	private Set<Turma> turma = new HashSet<>();

}
