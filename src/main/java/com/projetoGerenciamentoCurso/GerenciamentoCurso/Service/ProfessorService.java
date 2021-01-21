package com.projetoGerenciamentoCurso.GerenciamentoCurso.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto.ProfessorDto;

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
