package com.projetogerenciamentocurso.gerenciamentocurso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetogerenciamentocurso.gerenciamentocurso.dto.AlunoDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.AlunoDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.exceptions.AlunoException;
import com.projetogerenciamentocurso.gerenciamentocurso.service.AlunoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = AlunoController.PATH)
@AllArgsConstructor
public class AlunoController {

	public static final String PATH = "/aluno";

	
	private final AlunoService alunoService;
	
	@PostMapping
	public ResponseEntity<AlunoDtoResposta> salvarAluno(@RequestBody AlunoDto aluno)throws AlunoException {
		
		 
		return ResponseEntity.ok( alunoService.criarAluno(aluno));
	}

	@PutMapping
	public ResponseEntity<AlunoDtoResposta> atualizarAluno(@RequestBody AlunoDto atualizaAluno)throws AlunoException {
		AlunoDtoResposta aluno = alunoService.atualizarAluno(atualizaAluno);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);

		} else {
			return ResponseEntity.notFound().build();

		}

	}

	@DeleteMapping
	public ResponseEntity<AlunoDtoResposta> deletarAluno(@RequestBody AlunoDto aluno) {

		AlunoDtoResposta deletarALuno = alunoService.deletarAluno(aluno);
		if (deletarALuno != null) {

			
			return ResponseEntity.ok(deletarALuno);

		} else {

			return ResponseEntity.notFound().build();

		}

	}

}
