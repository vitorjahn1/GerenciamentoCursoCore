package com.projetogerenciamentocurso.gerenciamentocurso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ProfessorException extends RuntimeException {

	private static final long serialVersionUID = 2032886023727999997L;

	public ProfessorException(String mensagem) {
		
		super(mensagem);
	}
}
