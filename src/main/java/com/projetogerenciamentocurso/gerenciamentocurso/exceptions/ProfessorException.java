package com.projetogerenciamentocurso.gerenciamentocurso.exceptions;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class ProfessorException extends ConstraintViolationException{

	private static final long serialVersionUID = -2259960717396228680L;

	public ProfessorException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
		
	}

}
