package com.projetogerenciamentocurso.gerenciamentocurso.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.GerenciamentoCursoApplication;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.DisciplinaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.DisciplinaDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.exceptions.DisciplinaException;
import com.projetogerenciamentocurso.gerenciamentocurso.mensageria.Publisher;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Disciplina;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.DisciplinaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class DisciplinaService {

	private final Publisher publisher;
	
	private final DisciplinaRepository disciplinaRepository;
	
	private final ProfessorService professorService;

	public DisciplinaDtoResposta criarDisciplina(DisciplinaDto disciplina) {
		
		Disciplina disciplinaModel = criarModelDisciplina(disciplina);
		
		disciplinaRepository.save(disciplinaModel);
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_DISCIPLINA_CRIAR, disciplina);
		
		return criarDisciplinaDtoResposta(disciplina);
	}

	public DisciplinaDtoResposta atualizarDisciplina(DisciplinaDto disciplina) {
		try {
			
			Disciplina disciplinaAtualiza = disciplinaRepository.getOne(disciplina.getIdDisciplina());
			disciplinaAtualiza.setIdDisciplina(disciplina.getIdDisciplina());
			disciplinaAtualiza.setDescricao(disciplina.getDescricao());
			disciplinaAtualiza.setCargaHoraria(disciplina.getCargaHoraria());
			disciplinaAtualiza.setSigla(disciplina.getSigla());
			if(disciplina.getProfessor()!= null)
				disciplinaAtualiza.setProfessor(professorService.criarModelProfessor(disciplina.getProfessor()));
			disciplinaRepository.save(disciplinaAtualiza);
		}catch (EntityNotFoundException e) {
			throw new DisciplinaException("Disciplina não encontrada");
		}
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_DISCIPLINA_ATUALIZAR, disciplina);

		return criarDisciplinaDtoResposta(disciplina);
	}

	public DisciplinaDtoResposta deletarDisciplina(DisciplinaDto disciplina) {
		
		try {
			Disciplina disciplinaDeletar = disciplinaRepository.getOne(disciplina.getIdDisciplina());
			
			disciplinaRepository.delete(disciplinaDeletar);
		}catch (EntityNotFoundException e) {
			throw new DisciplinaException("Disciplina não encontrada");
		}
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_DISCIPLINA_DELETAR, disciplina);
		
		return criarDisciplinaDtoResposta(disciplina);
	}

	private Disciplina criarModelDisciplina(DisciplinaDto disciplinaDto) {

		Disciplina disciplianaModel = new Disciplina();

		disciplianaModel.setDescricao(disciplinaDto.getDescricao());
		disciplianaModel.setCargaHoraria(disciplinaDto.getCargaHoraria());
		disciplianaModel.setSigla(disciplinaDto.getSigla());
		if(disciplinaDto.getProfessor()!= null)
			disciplianaModel.setProfessor(professorService.criarModelProfessor(disciplinaDto.getProfessor()));
		disciplianaModel.setIdDisciplina(disciplinaDto.getIdDisciplina());
		return disciplianaModel;
	}
	
	private DisciplinaDtoResposta criarDisciplinaDtoResposta(DisciplinaDto disciplinaDto) {
		
		DisciplinaDtoResposta disciplianaDtoResposta = new DisciplinaDtoResposta();
		disciplianaDtoResposta.setIdDisciplina(disciplinaDto.getIdDisciplina());
		disciplianaDtoResposta.setDescricao(disciplinaDto.getDescricao());
		disciplianaDtoResposta.setCargaHoraria(disciplinaDto.getCargaHoraria());
		disciplianaDtoResposta.setSigla(disciplinaDto.getSigla());
		if(disciplinaDto.getProfessor() != null)
			disciplianaDtoResposta.setProfessor(professorService.criarProfessorDtoResposta(disciplinaDto.getProfessor()));

		return disciplianaDtoResposta;
	}
}
