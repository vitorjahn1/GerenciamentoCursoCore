package com.projetogerenciamentocurso.gerenciamentocurso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class TurmaException extends RuntimeException{

	private static final long serialVersionUID = 5891289913524251413L;

	public TurmaException(String mensagem) {
		
		super(mensagem);
	}
}
