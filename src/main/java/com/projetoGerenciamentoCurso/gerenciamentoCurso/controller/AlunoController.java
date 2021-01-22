package com.projetoGerenciamentoCurso.gerenciamentoCurso.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.dto.AlunoDto;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Aluno;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.service.AlunoService;

@RestController
@RequestMapping(path = AlunoController.PATH)
public class AlunoController {

	public static final String PATH = "/aluno";

	@Autowired
	private AlunoService alunoService;

	@PostMapping
	@Transactional
	public ResponseEntity<Aluno> salvarAluno(@RequestBody AlunoDto aluno) {
		Aluno alunoModel = alunoService.criarAlunoModel(aluno);

		return ResponseEntity.ok(alunoModel);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<Aluno> atualizarAluno(@RequestBody AlunoDto atualizaAluno) {
		Aluno aluno = alunoService.atualizarAluno(atualizaAluno);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);

		} else {
			return ResponseEntity.notFound().build();

		}

	}

	@DeleteMapping
	public ResponseEntity<Aluno> deletarAluno(@RequestBody AlunoDto aluno) {

		Aluno deletarALuno = alunoService.deletarAluno(aluno);
		if (deletarALuno != null) {

			
			return ResponseEntity.ok(deletarALuno);

		} else {

			return ResponseEntity.notFound().build();

		}

	}

}