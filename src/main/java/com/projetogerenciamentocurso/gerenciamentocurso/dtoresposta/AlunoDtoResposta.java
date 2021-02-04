package com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta;

import java.io.Serializable;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Pessoa;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AlunoDtoResposta extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = -4296495523020562879L;

	private Integer matricula;

	private String formaIngresso;

}
