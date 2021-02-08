package com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AlunoDtoResposta extends PessoaDtoResposta implements Serializable{
	
	private static final long serialVersionUID = -4296495523020562879L;

	private Integer matricula;

	private String formaIngresso;

}
