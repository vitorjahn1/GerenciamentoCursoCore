package com.projetoGerenciamentoCurso.gerenciamentoCurso.service.repositoryServices;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.dto.ProfessorDto;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Professor;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.repository.ProfessorRepository;


public class ProfessorRepositoryService {
	@Autowired
	ProfessorRepository professorRepository;
	
	public void repositoryCriarProfessor(Professor professor) {
		
		professorRepository.save(professor);
	}
	
	public void repositoryAtualizarProfessor(Professor professor) {
		
		professorRepository.save(professor);
	}
	
	public void repositoryDeletarProfessor(Professor professor) {
		
		professorRepository.delete(professor);
	}
	
	public Professor repositoryEncontrarProfessor(Integer idProfessor) {
		
		Professor professorRetorno = professorRepository.getOne(idProfessor);
		
		return professorRetorno;
	}
	
	public Professor criarModelProfessor(ProfessorDto professorDto) {
		
		Professor criaProfessorDto = new Professor();
		
		criaProfessorDto.setCpf(professorDto.getCpf());
		criaProfessorDto.setEmail(professorDto.getEmail());
		criaProfessorDto.setNome(professorDto.getNome());
		criaProfessorDto.setTitulacao(professorDto.getTitulacao());
		
		return criaProfessorDto;
	}
}
