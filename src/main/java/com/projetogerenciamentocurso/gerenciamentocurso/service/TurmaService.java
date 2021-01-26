package com.projetogerenciamentocurso.gerenciamentocurso.service;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.GerenciamentoCursoApplication;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.TurmaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.mensageria.Publisher;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Turma;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.TurmaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class TurmaService {

	@Autowired
	private Publisher publisher;

	@Autowired
	TurmaRepository turmaRepository;
	
	public Turma atualizaTurma(TurmaDto turmaDto) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_TURMA_ATUALIZAR, turmaDto);
		Turma turmaModel = turmaRepository.getOne(turmaDto.getIdTurma());
		if(turmaModel != null) {
			turmaModel.setAlunos(turmaDto.getAlunos());
			turmaModel.setAnoLetivo(turmaDto.getAnoLetivo());
			turmaModel.setDescricao(turmaDto.getDescricao());
			turmaModel.setNumeroVagas(turmaDto.getNumeroVagas());
			turmaModel.setPeriodoLetivo(turmaDto.getPeriodoLetivo());
			
			turmaRepository.save(turmaModel);
		}
		return turmaModel;
	}

	public Turma criarTurma(TurmaDto turma) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_TURMA_CRIAR, turma);
		
		Turma turmaModel = criarModelTurma(turma);
		
		return turmaModel;
	}

	public Turma deletarTurma(TurmaDto turma) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_TURMA_DELETAR, turma);
		Turma turmaModel = turmaRepository.getOne(turma.getIdTurma());
		
		if(turmaModel != null) {
			
			turmaRepository.delete(turmaModel);
		}
		return turmaModel;
	}

	public Turma criarModelTurma(TurmaDto turmaDto) {
		
		Turma turma = new Turma();
		
		turma.setAlunos(turmaDto.getAlunos());
		turma.setAnoLetivo(turmaDto.getAnoLetivo());
		turma.setDescricao(turmaDto.getDescricao());
		turma.setNumeroVagas(turmaDto.getNumeroVagas());
		turma.setPeriodoLetivo(turmaDto.getPeriodoLetivo());
		
		return turma;
	}
}
