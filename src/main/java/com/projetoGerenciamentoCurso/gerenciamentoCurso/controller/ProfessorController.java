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

import com.projetoGerenciamentoCurso.gerenciamentoCurso.dto.ProfessorDto;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Professor;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.service.ProfessorService;


@RestController
@RequestMapping(path = ProfessorController.PATH)
public class ProfessorController {

	
	
	@Autowired
	private ProfessorService professorService;
	
	public static final String PATH = "/professor";
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<Professor> salvaProfessor(@RequestBody ProfessorDto professor) {
		Professor professorModel = professorService.criarProfessor(professor);
		
		return ResponseEntity.ok(professorModel);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<Professor> atualizaProfessor(@RequestBody ProfessorDto professor) {
		Professor atualizaProfessor = professorService.atuzalizarProfessor(professor);
		if(atualizaProfessor != null) {
			
			
			return ResponseEntity.ok(atualizaProfessor);
			
		}else {
			
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity<Professor> deletarProfessor(@RequestBody ProfessorDto professor) {
		
		Professor deletarProfessor = professorService.deletarProfessor(professor);
		
		if(deletarProfessor != null) {
			
			return ResponseEntity.ok(deletarProfessor);
		}else {
			
			return ResponseEntity.notFound().build();
		}
		
		
	}
}