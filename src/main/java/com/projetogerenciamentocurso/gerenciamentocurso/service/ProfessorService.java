package com.projetogerenciamentocurso.gerenciamentocurso.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.GerenciamentoCursoApplication;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.ProfessorDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.ProfessorDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.exceptions.ProfessorException;
import com.projetogerenciamentocurso.gerenciamentocurso.mensageria.Publisher;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Professor;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.ProfessorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ProfessorService {

	private final Publisher publisher;

	private final ProfessorRepository professorRepository;
	
	public ProfessorDtoResposta criarProfessor(ProfessorDto professor) {
		
		Professor professorModel = criarModelProfessor(professor);
		
		professorRepository.save(professorModel);
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_PROFESSOR_CRIAR, professor);
		
		return criarProfessorDtoResposta(professor);
	}

	public ProfessorDtoResposta atualizarProfessor(ProfessorDto professor) {
		try {
			Professor atualizaProfessor = professorRepository.getOne(professor.getIdPessoa());
			
			atualizaProfessor.setCpf(professor.getCpf());
			atualizaProfessor.setEmail(professor.getEmail());
			atualizaProfessor.setNome(professor.getNome());
			atualizaProfessor.setTitulacao(professor.getTitulacao());
			atualizaProfessor.setIdProfessor(professor.getIdProfessor());
			atualizaProfessor.setIdPessoa(professor.getIdPessoa());
			
			professorRepository.save(atualizaProfessor);
		}catch (EntityNotFoundException e) {
			throw new ProfessorException("Professor não encontrado");
		}
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
					GerenciamentoCursoApplication.ROUTING_PROFESSOR_ATUALIZAR, professor);
	
		return criarProfessorDtoResposta(professor);
	}

	public ProfessorDtoResposta deletarProfessor(ProfessorDto professor) {
		try {
			Professor professorDeletar = professorRepository.getOne(professor.getIdProfessor());
			
			professorRepository.delete(professorDeletar);
		}catch (EntityNotFoundException e) {
			throw new ProfessorException("Professor não encontrado");
		}
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
					GerenciamentoCursoApplication.ROUTING_PROFESSOR_DELETAR, professor);
		
		return criarProfessorDtoResposta(professor);
	}

	public Professor criarModelProfessor(ProfessorDto professorDto) {

		Professor criaProfessorModel = new Professor();

		criaProfessorModel.setCpf(professorDto.getCpf());
		criaProfessorModel.setEmail(professorDto.getEmail());
		criaProfessorModel.setNome(professorDto.getNome());
		criaProfessorModel.setTitulacao(professorDto.getTitulacao());
		criaProfessorModel.setIdProfessor(professorDto.getIdProfessor());
		criaProfessorModel.setIdPessoa(professorDto.getIdPessoa());
		
		
		return criaProfessorModel;
	}
	
	public ProfessorDtoResposta criarProfessorDtoResposta(ProfessorDto professorDto) {
		
		ProfessorDtoResposta professorDtoResposta = new ProfessorDtoResposta();

		professorDtoResposta.setCpf(professorDto.getCpf());
		professorDtoResposta.setEmail(professorDto.getEmail());
		professorDtoResposta.setNome(professorDto.getNome());
		professorDtoResposta.setTitulacao(professorDto.getTitulacao());
		professorDtoResposta.setIdProfessor(professorDto.getIdProfessor());
		professorDtoResposta.setIdPessoa(professorDto.getIdPessoa());
		
		return professorDtoResposta;
	}
	
}
