package com.projetogerenciamentocurso.gerenciamentocurso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetogerenciamentocurso.gerenciamentocurso.dto.TurmaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.TurmaDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.service.TurmaService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping(path = TurmaController.PATH)
@AllArgsConstructor
public class TurmaController {
	
	private final TurmaService turmaService;

	public static final String PATH = "/turma";

	@PostMapping
	public ResponseEntity<TurmaDtoResposta> criarTurma(@RequestBody TurmaDto turma) {
		
		return ResponseEntity.ok(turmaService.criarTurma(turma));
	}

	@PutMapping
	public ResponseEntity<TurmaDtoResposta> atualizarTurma(@RequestBody TurmaDto turma) {
		
		return ResponseEntity.ok(turmaService.atualizaTurma(turma));
	}

	@DeleteMapping
	public ResponseEntity<TurmaDtoResposta> deletarTurma(@RequestBody TurmaDto turma) {

		return ResponseEntity.ok(turmaService.deletarTurma(turma));
	}
}
