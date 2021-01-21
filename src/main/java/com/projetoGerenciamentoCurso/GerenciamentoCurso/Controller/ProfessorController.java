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

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto.ProfessorDto;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Professor;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.ProfessorService;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.RepositoryServices.ProfessorRepositoryService;
@RestController
@RequestMapping(path = ProfessorController.PATH)
public class ProfessorController {

	@Autowired
	private ProfessorRepositoryService professorRepositoryService;
	
	@Autowired
	private ProfessorService professorService;
	
	public static final String PATH = "/professor";
	

	
	@PostMapping
	@Transactional
	public ResponseEntity<Professor> salvaProfessor(@RequestBody ProfessorDto professor) {
		Professor professorModel = professorRepositoryService.criarModelProfessor(professor);
		professorRepositoryService.repositoryCriarProfessor(professorModel);
		professorService.criarProfessor(professor);
		return ResponseEntity.ok(professorModel);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<Professor> atualizaProfessor(@RequestBody ProfessorDto professor) {
		Professor atualizaProfessor = professorRepositoryService.repositoryEncontrarProfessor(professor.getIdPessoa());
		if(atualizaProfessor == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		atualizaProfessor.setCpf(professor.getCpf());
		atualizaProfessor.setEmail(professor.getEmail());
		atualizaProfessor.setNome(professor.getNome());
		atualizaProfessor.setTitulacao(professor.getTitulacao());
		
		professorService.atualizaProfessor(professor);
		
		
		return ResponseEntity.ok(atualizaProfessor);
		
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity<Professor> deletarProfessor(@RequestBody ProfessorDto professor) {
		
		Professor deletarProfessor = professorRepositoryService.criarModelProfessor(professor);
		
		professorRepositoryService.repositoryDeletarProfessor(deletarProfessor);
		
		professorService.deletarProfessor(professor);
		
		return ResponseEntity.ok(deletarProfessor);
	}
}
