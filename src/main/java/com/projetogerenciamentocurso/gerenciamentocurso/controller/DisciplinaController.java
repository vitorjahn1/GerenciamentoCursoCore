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

		DisciplinaDtoResposta disciplinaAtualiza = disciplinaService.atualizarDisciplina(disciplina);
		if (disciplinaAtualiza != null) {

			return ResponseEntity.ok(disciplinaAtualiza);
		} else {

			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping
	public ResponseEntity<DisciplinaDtoResposta> deletarDisciplina(@RequestBody DisciplinaDto disciplina) {

		DisciplinaDtoResposta deletarDisciplina = disciplinaService.deletarDisciplina(disciplina);
		if (deletarDisciplina != null) {

			return ResponseEntity.ok(deletarDisciplina);

		}
		return ResponseEntity.notFound().build();

	}

}
