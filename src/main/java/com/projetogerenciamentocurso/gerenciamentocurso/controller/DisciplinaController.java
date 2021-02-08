package com.projetogerenciamentocurso.gerenciamentocurso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetogerenciamentocurso.gerenciamentocurso.dto.DisciplinaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.DisciplinaDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.service.DisciplinaService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping(path = DisciplinaController.PATH)
@AllArgsConstructor
public class DisciplinaController {

	
	private final DisciplinaService disciplinaService;

	public static final String PATH = "/disciplina";

	@PostMapping
	public ResponseEntity<DisciplinaDtoResposta> criaDisciplina(@RequestBody DisciplinaDto disciplina) {

		return ResponseEntity.ok(disciplinaService.criarDisciplina(disciplina));
	}

	@PutMapping
	public ResponseEntity<DisciplinaDtoResposta> atualizarDisciplina(@RequestBody DisciplinaDto disciplina) {

		return ResponseEntity.ok(disciplinaService.atualizarDisciplina(disciplina));
	}

	@DeleteMapping
	public ResponseEntity<DisciplinaDtoResposta> deletarDisciplina(@RequestBody DisciplinaDto disciplina) {

		return ResponseEntity.ok(disciplinaService.deletarDisciplina(disciplina));
	}
}
