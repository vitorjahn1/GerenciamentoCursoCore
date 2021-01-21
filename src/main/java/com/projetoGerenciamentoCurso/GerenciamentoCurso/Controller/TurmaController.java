package com.projetoGerenciamentoCurso.GerenciamentoCurso.Controller;

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

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto.TurmaDto;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Turma;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.TurmaService;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.RepositoryServices.TurmaRepositoryService;
@CrossOrigin
@RestController
@RequestMapping(path = TurmaController.PATH)
public class TurmaController {
	
	@Autowired
	private TurmaRepositoryService turmaRepositoryService;
	
	@Autowired
	private TurmaService turmaService;
	
	
	public static final String PATH = "/turma";
	

	@PostMapping
	public ResponseEntity<Turma> criarTurma(@RequestBody TurmaDto turma) {
		Turma turmaModel = turmaRepositoryService.criarModelTurma(turma);
		turmaRepositoryService.repositoryCriarTurma(turmaModel);
		turmaService.criarTurma(turma);
		return ResponseEntity.ok(turmaModel);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<Turma> atualizarTurma(@RequestBody TurmaDto turma) {
		Turma atualizaTurma = turmaRepositoryService.repositoryEncontrarTurma(turma.getIdTurma());
		
		if(atualizaTurma == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		atualizaTurma.setAlunos(turma.getAlunos());
		atualizaTurma.setAnoLetivo(turma.getAnoLetivo());
		atualizaTurma.setDescricao(turma.getDescricao());
		atualizaTurma.setNumeroVagas(turma.getNumeroVagas());
		atualizaTurma.setPeriodoLetivo(turma.getPeriodoLetivo());
		
		turmaService.atualizaTurma(turma);
		
		return ResponseEntity.ok(atualizaTurma);
	}
	@DeleteMapping
	@Transactional
	public ResponseEntity<Turma> deletarTurma(@RequestBody TurmaDto turma) {
		
		
		if(turma == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		
		Turma deletarTurma = turmaRepositoryService.criarModelTurma(turma);
		turmaRepositoryService.repositoryDeletarTurma(deletarTurma);
		turmaService.deletarTurma(turma);
		return ResponseEntity.ok(deletarTurma);
		
	}
	
}
