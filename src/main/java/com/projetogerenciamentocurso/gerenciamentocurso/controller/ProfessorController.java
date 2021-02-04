package com.projetogerenciamentocurso.gerenciamentocurso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetogerenciamentocurso.gerenciamentocurso.dto.ProfessorDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.ProfessorDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.service.ProfessorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = ProfessorController.PATH)
@AllArgsConstructor
public class ProfessorController {
	
	private final ProfessorService professorService;
	
	public static final String PATH = "/professor";
	
	@PostMapping
	public ResponseEntity<ProfessorDtoResposta> salvaProfessor(@RequestBody ProfessorDto professor) {
		
		return ResponseEntity.ok( professorService.criarProfessor(professor));
	}
	
	@PutMapping
	public ResponseEntity<ProfessorDtoResposta> atualizaProfessor(@RequestBody ProfessorDto professor) {
		
		return ResponseEntity.ok(professorService.atualizarProfessor(professor));
	}
	
	@DeleteMapping
	public ResponseEntity<ProfessorDtoResposta> deletarProfessor(@RequestBody ProfessorDto professor) {
		
		return ResponseEntity.ok(professorService.deletarProfessor(professor));
	}
}
