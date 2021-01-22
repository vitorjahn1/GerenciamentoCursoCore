package com.projetoGerenciamentoCurso.gerenciamentoCurso.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.dto.DisciplinaDto;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Disciplina;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.repository.DisciplinaRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DisciplinaService {

	private final RabbitTemplate rabbitTemplate;

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	public Disciplina criarDisciplina(DisciplinaDto disciplina) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_DISCIPLINA_ATUALIZAR, disciplina);
		
		Disciplina disciplinaModel = criarModelDisciplina(disciplina);
		
		disciplinaRepository.save(disciplinaModel);
		
		return disciplinaModel;
	}

	public Disciplina atualizarDisciplina(DisciplinaDto disciplina) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
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

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
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
