package com.projetogerenciamentocurso.gerenciamentocurso.exceptions;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class TurmaException extends ConstraintViolationException{

	private static final long serialVersionUID = 391262580150974562L;

	public TurmaException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
		
	}

}
