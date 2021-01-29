package com.projetogerenciamentocurso.gerenciamentocurso.exceptions;

public class TurmaException extends RuntimeException{

	private static final long serialVersionUID = 5891289913524251413L;

	public TurmaException(String mensagem) {
		
		super(mensagem);
	}
}
