package com.projetogerenciamentocurso.gerenciamentocurso.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.GerenciamentoCursoApplication;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.ProfessorDto;
import com.projetogerenciamentocurso.gerenciamentocurso.mensageria.Publisher;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Professor;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.ProfessorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ProfessorService {

	@Autowired
	private Publisher publisher;

	
	private final ProfessorRepository professorRepository;
	
	public Professor criarProfessor(ProfessorDto professor) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_PROFESSOR_ATUALIZAR, professor);
		
		Professor professorModel = criarModelProfessor(professor);
		
		professorRepository.save(criarModelProfessor(professor));
		
		return professorModel;
		 
	}

	public Professor atuzalizarProfessor(ProfessorDto professor) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_PROFESSOR_CRIAR, professor);
		
		Professor atualizaProfessor = professorRepository.getOne(professor.getIdPessoa());
		if(atualizaProfessor!=null) {
			
			atualizaProfessor.setCpf(professor.getCpf());
			atualizaProfessor.setEmail(professor.getEmail());
			atualizaProfessor.setNome(professor.getNome());
			atualizaProfessor.setTitulacao(professor.getTitulacao());
			professorRepository.save(atualizaProfessor);
			
		}
		
		return atualizaProfessor;
	}

	public Professor deletarProfessor(ProfessorDto professor) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_PROFESSOR_DELETAR, professor);
		
		Professor professorModel = criarModelProfessor(professor);
		
		professorRepository.delete(professorModel);
		return professorModel;
	}

	private Professor criarModelProfessor(ProfessorDto professorDto) {

		Professor criaProfessorDto = new Professor();

		criaProfessorDto.setCpf(professorDto.getCpf());
		criaProfessorDto.setEmail(professorDto.getEmail());
		criaProfessorDto.setNome(professorDto.getNome());
		criaProfessorDto.setTitulacao(professorDto.getTitulacao());

		return criaProfessorDto;
	}
}
