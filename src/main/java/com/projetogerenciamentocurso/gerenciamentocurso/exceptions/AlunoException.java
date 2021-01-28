package com.projetogerenciamentocurso.gerenciamentocurso.exceptions;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;



public class AlunoException extends ConstraintViolationException{
	
	
	private static final long serialVersionUID = -915975808911160221L;
	
	public AlunoException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		
		super(constraintViolations);
	}
	
}
