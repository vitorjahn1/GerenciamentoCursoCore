package com.projetoGerenciamentoCurso.gerenciamentoCurso.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.dto.ProfessorDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorService {

	private final RabbitTemplate rabbitTemplate;

	public void atualizaProfessor(ProfessorDto professor) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_PROFESSOR_ATUALIZAR, professor);

	}

	public void criarProfessor(ProfessorDto professor) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_PROFESSOR_CRIAR, professor);

	}

	public void deletarProfessor(ProfessorDto professor) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_PROFESSOR_DELETAR, professor);

	}

}
