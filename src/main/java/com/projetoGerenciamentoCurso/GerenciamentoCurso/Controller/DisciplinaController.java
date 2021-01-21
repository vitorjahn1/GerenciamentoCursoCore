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

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto.DisciplinaDto;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Disciplina;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.DisciplinaService;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.RepositoryServices.DisciplinaRepositoryService;
@CrossOrigin
@RestController
@RequestMapping(path = DisciplinaController.PATH)
public class DisciplinaController {
	@Autowired
	private DisciplinaRepositoryService disciplinaRepositoryService;
	
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	public static final String PATH = "/disciplina";
	

	
	@PostMapping
	@Transactional
	public ResponseEntity<Disciplina> criaDisciplina(@RequestBody DisciplinaDto disciplina) {
		
		Disciplina disciplinaModel = disciplinaRepositoryService.criarModelDisciplina(disciplina);
		disciplinaService.criarDisciplina(disciplina);
		disciplinaRepositoryService.repositoryCriarDisciplina(disciplinaModel);
		return ResponseEntity.ok(disciplinaModel);
		
	}
	@PutMapping
	@Transactional
	public ResponseEntity<Disciplina> atualizarDisciplina(@RequestBody DisciplinaDto disciplina) {
		
		Disciplina disciplinaAtualiza = disciplinaRepositoryService.repositoryEncontrarDisciplina(disciplina.getIdDisciplina());		
		if(disciplinaAtualiza == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		disciplinaAtualiza.setProfessores(disciplina.getProfessores());
		disciplinaAtualiza.setDescricao(disciplina.getDescricao());
		disciplinaAtualiza.setCargaHoraria(disciplina.getCargaHoraria());
		disciplinaAtualiza.setSigla(disciplina.getSigla());
		disciplinaAtualiza.setTurmas(disciplina.getTurmas());
		disciplinaRepositoryService.repositoryAtualizarDisciplina(disciplinaAtualiza);
		disciplinaService.atualizaDisciplina(disciplina);
		return ResponseEntity.ok(disciplinaAtualiza);
	}
	
	@DeleteMapping
	public  ResponseEntity<Disciplina> deletarDisciplina(@RequestBody DisciplinaDto disciplina) {
		
		Disciplina deletarDisciplina = disciplinaRepositoryService.criarModelDisciplina(disciplina);
		if(deletarDisciplina == null) {
			
			return ResponseEntity.notFound().build();
			
		}
		
		disciplinaRepositoryService.repositoryDeletarDisciplina(deletarDisciplina);
		disciplinaService.deletarDisciplina(disciplina);
		return ResponseEntity.ok(deletarDisciplina);
	}
}
