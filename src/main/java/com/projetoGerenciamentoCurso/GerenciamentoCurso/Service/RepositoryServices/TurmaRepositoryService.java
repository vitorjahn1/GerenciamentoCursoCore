package com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.RepositoryServices;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto.TurmaDto;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Turma;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository.TurmaRepository;

public class TurmaRepositoryService {
	
	@Autowired
	TurmaRepository turmaRepository;
	
	public void repositoryCriarTurma(Turma turma) {
		
		turmaRepository.save(turma);
	}
	
	public void repositoryAtualizarTurma(Turma turma) {
		
		turmaRepository.save(turma);
	}
	
	public void repositoryDeletarTurma(Turma turma) {
		
		turmaRepository.delete(turma);
	}
	
	public Turma repositoryEncontrarTurma(Integer idTurma) {
		
		Turma alunoRetorno = turmaRepository.getOne(idTurma);
		
		return alunoRetorno;
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
