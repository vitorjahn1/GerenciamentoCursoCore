package com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta;

import java.util.HashSet;
import java.util.Set;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Pessoa;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Turma;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AlunoDtoResposta extends Pessoa{
	
	private static final long serialVersionUID = -4296495523020562879L;

	private Integer matricula;

	private String formaIngresso;

	private Set<Turma> turma = new HashSet<>();
}
