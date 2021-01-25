package com.projetogerenciamentocurso.gerenciamentocurso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetogerenciamentocurso.gerenciamentocurso.dto.ProfessorDto;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Professor;
import com.projetogerenciamentocurso.gerenciamentocurso.service.ProfessorService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = ProfessorController.PATH)
@AllArgsConstructor
public class ProfessorController {
	
	
	private final ProfessorService professorService;
	
	public static final String PATH = "/professor";
	
	@PostMapping
	public ResponseEntity<Professor> salvaProfessor(@RequestBody ProfessorDto professor) {
		Professor professorModel = professorService.criarProfessor(professor);
		
		return ResponseEntity.ok(professorModel);
	}
	
	@PutMapping
	public ResponseEntity<Professor> atualizaProfessor(@RequestBody ProfessorDto professor) {
		Professor atualizaProfessor = professorService.atuzalizarProfessor(professor);
		if(atualizaProfessor != null) {
			
			return ResponseEntity.ok(atualizaProfessor);
			
		}else {
			
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping
	public ResponseEntity<Professor> deletarProfessor(@RequestBody ProfessorDto professor) {
		
		Professor deletarProfessor = professorService.deletarProfessor(professor);
		
		if(deletarProfessor != null) {
			
			return ResponseEntity.ok(deletarProfessor);
		}else {
			
			return ResponseEntity.notFound().build();
		}
		
	}
}
