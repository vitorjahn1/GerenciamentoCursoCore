package com.projetogerenciamentocurso.gerenciamentocurso.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetogerenciamentocurso.gerenciamentocurso.dto.TurmaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Turma;
import com.projetogerenciamentocurso.gerenciamentocurso.service.TurmaService;

@CrossOrigin
@RestController
@RequestMapping(path = TurmaController.PATH)
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	public static final String PATH = "/turma";

	@PostMapping
	public ResponseEntity<Turma> criarTurma(@RequestBody TurmaDto turma) {
		Turma turmaModel = turmaService.criarTurma(turma);

		return ResponseEntity.ok(turmaModel);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<Turma> atualizarTurma(@RequestBody TurmaDto turma) {
		Turma atualizaTurma = turmaService.atualizaTurma(turma);
		if (atualizaTurma != null) {

			return ResponseEntity.ok(atualizaTurma);
		} else {

			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping
	@Transactional
	public ResponseEntity<Turma> deletarTurma(@RequestBody TurmaDto turma) {

		Turma deletarTurma = turmaService.deletarTurma(turma);
		if (deletarTurma != null) {
			return ResponseEntity.ok(deletarTurma);

		} else {

			return ResponseEntity.notFound().build();
		}

	}

}
