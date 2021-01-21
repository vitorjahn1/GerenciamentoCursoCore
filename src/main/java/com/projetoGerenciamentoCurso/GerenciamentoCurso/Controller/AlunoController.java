package com.projetoGerenciamentoCurso.GerenciamentoCurso.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto.AlunoDto;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Aluno;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.AlunoService;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.RepositoryServices.AlunoRepositoryService;

@RestController
@RequestMapping(path = AlunoController.PATH)
public class AlunoController {

	@Autowired
	private AlunoRepositoryService alunoRepositoryService;

	

	public static final String PATH = "/aluno";

	@Autowired
	private AlunoService alunoService;

	@PostMapping
	@Transactional
	public ResponseEntity<Aluno> salvarAluno(@RequestBody AlunoDto aluno) {
		Aluno criaAluno = alunoRepositoryService.criarAlunoModel(aluno);
		
		alunoRepositoryService.repositoryCriarAluno(criaAluno);
		
		alunoService.retornaAluno(aluno);
		return ResponseEntity.ok(criaAluno);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<Aluno> atualizarAluno(@RequestBody AlunoDto atualizaAluno) {
		Aluno aluno = alunoRepositoryService.repositoryEncontrarAluno(atualizaAluno.getMatricula());
		if (aluno != null) {

			aluno.setCpf(atualizaAluno.getCpf());
			aluno.setEmail(atualizaAluno.getEmail());
			aluno.setFormaIngresso(atualizaAluno.getFormaIngresso());
			aluno.setNome(atualizaAluno.getNome());
			aluno.setTurma(atualizaAluno.getTurma());
			alunoService.atualizarAluno(atualizaAluno);
			alunoRepositoryService.repositoryCriarAluno(aluno);
		} else {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(aluno);

	}

	@DeleteMapping
	public ResponseEntity<Aluno> deletarAluno(@RequestBody AlunoDto aluno) {

		Aluno deletarALuno = alunoRepositoryService.criarAlunoModel(aluno);
		if (deletarALuno != null) {
			
			alunoRepositoryService.repositoryDeletarAluno(deletarALuno);
			
			alunoService.deletarAluno(aluno);
			
		} else {

			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(deletarALuno);
	}

}
