package com.projetogerenciamentocurso.gerenciamentocurso.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.GerenciamentoCursoApplication;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.DisciplinaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.mensageria.Publisher;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Disciplina;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.DisciplinaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class DisciplinaService {

	@Autowired
	private Publisher publisher;

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	public Disciplina criarDisciplina(DisciplinaDto disciplina) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_DISCIPLINA_ATUALIZAR, disciplina);
		
		Disciplina disciplinaModel = criarModelDisciplina(disciplina);
		
		disciplinaRepository.save(disciplinaModel);
		
		return disciplinaModel;
	}

	public Disciplina atualizarDisciplina(DisciplinaDto disciplina) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_DISCIPLINA_CRIAR, disciplina);

		Disciplina disciplinaAtualiza = disciplinaRepository.getOne(disciplina.getIdDisciplina());
		if (disciplinaAtualiza != null) {

			disciplinaAtualiza.setProfessores(disciplina.getProfessores());
			disciplinaAtualiza.setDescricao(disciplina.getDescricao());
			disciplinaAtualiza.setCargaHoraria(disciplina.getCargaHoraria());
			disciplinaAtualiza.setSigla(disciplina.getSigla());
			disciplinaAtualiza.setTurmas(disciplina.getTurmas());

			disciplinaRepository.save(disciplinaAtualiza);
		}

		return disciplinaAtualiza;
	}

	public Disciplina deletarDisciplina(DisciplinaDto disciplina) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_DISCIPLINA_DELETAR, disciplina);

		Disciplina disciplinaModel = criarModelDisciplina(disciplina);
		if (disciplinaModel != null) {
			disciplinaRepository.delete(disciplinaModel);
		}
		return disciplinaModel;
	}

	public Disciplina criarModelDisciplina(DisciplinaDto disciplinaDto) {

		Disciplina disciplianModel = new Disciplina();

		disciplianModel.setProfessores(disciplinaDto.getProfessores());
		disciplianModel.setDescricao(disciplinaDto.getDescricao());
		disciplianModel.setCargaHoraria(disciplinaDto.getCargaHoraria());
		disciplianModel.setSigla(disciplinaDto.getSigla());
		disciplianModel.setTurmas(disciplinaDto.getTurmas());

		return disciplianModel;
	}
}
