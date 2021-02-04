package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AlunoDto extends PessoaDto{

	private static final long serialVersionUID = 1499231588972071898L;

	@Id
	private Integer matricula;

	private String formaIngresso;

}
