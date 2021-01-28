package com.projetogerenciamentocurso.gerenciamentocurso.exceptions;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class DisciplinaException extends ConstraintViolationException{

	private static final long serialVersionUID = -5917253023331594454L;

	public DisciplinaException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
		
	}

}
