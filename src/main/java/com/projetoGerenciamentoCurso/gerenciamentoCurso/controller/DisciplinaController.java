package com.projetoGerenciamentoCurso.gerenciamentoCurso.controller;

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

import com.projetoGerenciamentoCurso.gerenciamentoCurso.dto.DisciplinaDto;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Disciplina;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.service.DisciplinaService;


@CrossOrigin
@RestController
@RequestMapping(path = DisciplinaController.PATH)
public class DisciplinaController {

	
	@Autowired
	private DisciplinaService disciplinaService;
	
	public static final String PATH = "/disciplina";
	
	@PostMapping
	@Transactional
	public ResponseEntity<Disciplina> criaDisciplina(@RequestBody DisciplinaDto disciplina) {
		
		Disciplina disciplinaModel = disciplinaService.criarDisciplina(disciplina);
		disciplinaService.criarDisciplina(disciplina);
		
		return ResponseEntity.ok(disciplinaModel);
		
	}
	@PutMapping
	@Transactional
	public ResponseEntity<Disciplina> atualizarDisciplina(@RequestBody DisciplinaDto disciplina) {
		
		Disciplina disciplinaAtualiza = disciplinaService.atualizarDisciplina(disciplina);		
		if(disciplinaAtualiza != null) {
			
			return ResponseEntity.ok(disciplinaAtualiza);
		}else {
			
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	@DeleteMapping
	public  ResponseEntity<Disciplina> deletarDisciplina(@RequestBody DisciplinaDto disciplina) {
		
		Disciplina deletarDisciplina = disciplinaService.deletarDisciplina(disciplina);
		if(deletarDisciplina != null) {
			
			return ResponseEntity.ok(deletarDisciplina);
			
		}
		return ResponseEntity.notFound().build();
		
	}
	
}
