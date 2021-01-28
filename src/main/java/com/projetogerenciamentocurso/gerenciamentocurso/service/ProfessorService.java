package com.projetogerenciamentocurso.gerenciamentocurso.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.GerenciamentoCursoApplication;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.ProfessorDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.ProfessorDtoResposta;
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
				GerenciamentoCursoApplication.ROUTING_PROFESSOR_ATUALIZAR, professor);
		
		return criarProfessorDtoResposta(professor);
		 
	}

	public ProfessorDtoResposta atuzalizarProfessor(ProfessorDto professor) {

		Professor atualizaProfessor = professorRepository.getOne(professor.getIdPessoa());
		if(atualizaProfessor!=null) {
			
			atualizaProfessor.setCpf(professor.getCpf());
			atualizaProfessor.setEmail(professor.getEmail());
			atualizaProfessor.setNome(professor.getNome());
			atualizaProfessor.setTitulacao(professor.getTitulacao());
			professorRepository.save(atualizaProfessor);
			
			publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
					GerenciamentoCursoApplication.ROUTING_PROFESSOR_CRIAR, professor);
		}
		
		return criarProfessorDtoResposta(professor);
	}

	public ProfessorDtoResposta deletarProfessor(ProfessorDto professor) {

		Professor professorModel = criarModelProfessor(professor);
		
		professorRepository.delete(professorModel);
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_PROFESSOR_DELETAR, professor);
		return criarProfessorDtoResposta(professor);
	}

	private Professor criarModelProfessor(ProfessorDto professorDto) {

		Professor criaProfessorDto = new Professor();

		criaProfessorDto.setCpf(professorDto.getCpf());
		criaProfessorDto.setEmail(professorDto.getEmail());
		criaProfessorDto.setNome(professorDto.getNome());
		criaProfessorDto.setTitulacao(professorDto.getTitulacao());

		return criaProfessorDto;
	}
	
	private ProfessorDtoResposta criarProfessorDtoResposta(ProfessorDto professorDto) {
		
		ProfessorDtoResposta professorDtoResposta = new ProfessorDtoResposta();

		professorDtoResposta.setCpf(professorDto.getCpf());
		professorDtoResposta.setEmail(professorDto.getEmail());
		professorDtoResposta.setNome(professorDto.getNome());
		professorDtoResposta.setTitulacao(professorDto.getTitulacao());

		return professorDtoResposta;
		
	}
}
