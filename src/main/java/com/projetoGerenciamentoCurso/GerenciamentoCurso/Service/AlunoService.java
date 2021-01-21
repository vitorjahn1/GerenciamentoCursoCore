package com.projetoGerenciamentoCurso.GerenciamentoCurso.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto.AlunoDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService {

	private final RabbitTemplate rabbitTemplate;

	public void retornaAluno(AlunoDto aluno) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY, aluno);

	}

	public void deletarAluno(AlunoDto aluno) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY_ALUNO_DELETAR, aluno);
	}

	public void atualizarAluno(AlunoDto aluno) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY_ALUNO, aluno);
	}

}
