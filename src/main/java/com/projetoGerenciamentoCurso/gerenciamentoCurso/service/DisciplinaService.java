package com.projetoGerenciamentoCurso.gerenciamentoCurso.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.dto.DisciplinaDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DisciplinaService {

	
	private final RabbitTemplate rabbitTemplate;

	public void atualizaDisciplina(DisciplinaDto disciplina) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_DISCIPLINA_ATUALIZAR, disciplina);

	}

	public void criarDisciplina(DisciplinaDto disciplina) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_DISCIPLINA_CRIAR, disciplina);

	}

	public void deletarDisciplina(DisciplinaDto disciplina) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_DISCIPLINA_DELETAR, disciplina);

	}

}
