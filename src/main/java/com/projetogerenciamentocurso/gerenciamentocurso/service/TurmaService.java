package com.projetogerenciamentocurso.gerenciamentocurso.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.GerenciamentoCursoApplication;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.TurmaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.TurmaDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.mensageria.Publisher;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Turma;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.TurmaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class TurmaService {

	
	private final Publisher publisher;

	private final TurmaRepository turmaRepository;

	public TurmaDtoResposta atualizaTurma(TurmaDto turmaDto) {

		Turma turmaModel = turmaRepository.getOne(turmaDto.getIdTurma());
		if (turmaModel != null) {
			turmaModel.setAlunos(turmaDto.getAlunos());
			turmaModel.setAnoLetivo(turmaDto.getAnoLetivo());
			turmaModel.setDescricao(turmaDto.getDescricao());
			turmaModel.setNumeroVagas(turmaDto.getNumeroVagas());
			turmaModel.setPeriodoLetivo(turmaDto.getPeriodoLetivo());

			turmaRepository.save(turmaModel);
			
			publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
					GerenciamentoCursoApplication.ROUTING_TURMA_ATUALIZAR, turmaDto);
		}
		return criarTurmaDtoResposta(turmaDto);
	}

	public TurmaDtoResposta criarTurma(TurmaDto turma) {

		Turma turmaModel = criarModelTurma(turma);
		
		turmaRepository.save(turmaModel);
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_TURMA_CRIAR,
				turma);
		
		return criarTurmaDtoResposta(turma);
	}

	public TurmaDtoResposta deletarTurma(TurmaDto turma) {

		
		Turma turmaModel = turmaRepository.getOne(turma.getIdTurma());

		if (turmaModel != null) {
			
			publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_TURMA_DELETAR,
					turma);
			turmaRepository.delete(turmaModel);
		}
		return criarTurmaDtoResposta(turma);
	}

	private Turma criarModelTurma(TurmaDto turmaDto) {

		Turma turma = new Turma();

		turma.setAlunos(turmaDto.getAlunos());
		turma.setAnoLetivo(turmaDto.getAnoLetivo());
		turma.setDescricao(turmaDto.getDescricao());
		turma.setNumeroVagas(turmaDto.getNumeroVagas());
		turma.setPeriodoLetivo(turmaDto.getPeriodoLetivo());

		return turma;
	}

	private TurmaDtoResposta criarTurmaDtoResposta(TurmaDto turmaDto) {
		
		TurmaDtoResposta turma = new TurmaDtoResposta();
		
		turma.setAlunos(turmaDto.getAlunos());
		turma.setAnoLetivo(turmaDto.getAnoLetivo());
		turma.setDescricao(turmaDto.getDescricao());
		turma.setNumeroVagas(turmaDto.getNumeroVagas());
		turma.setPeriodoLetivo(turmaDto.getPeriodoLetivo());
		
		return turma;
	}
}
