package com.projetoGerenciamentoCurso.GerenciamentoCurso.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto.TurmaDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TurmaService {

	private final RabbitTemplate rabbitTemplate;

	public void atualizaTurma(TurmaDto turma) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_TURMA_ATUALIZAR, turma);

	}

	public void criarTurma(TurmaDto turma) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_TURMA_CRIAR, turma);

	}

	public void deletarTurma(TurmaDto turma) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_TURMA_DELETAR, turma);

	}

}
