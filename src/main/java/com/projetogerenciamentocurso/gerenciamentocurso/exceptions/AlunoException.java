package com.projetogerenciamentocurso.gerenciamentocurso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class AlunoException extends RuntimeException {

	private static final long serialVersionUID = 8519001518988272104L;

	public AlunoException(String mensagem) {
		
		super(mensagem);
	}
	
}
