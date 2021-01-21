package com.projetoGerenciamentoCurso.gerenciamentoCurso.service.repositoryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.dto.AlunoDto;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Aluno;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.repository.AlunoRepository;



@Service
public class AlunoRepositoryService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public void repositoryCriarAluno(Aluno aluno) {
		
		alunoRepository.save(aluno);
	}
	
	public void repositoryAtualizarAluno(Aluno aluno) {
		
		alunoRepository.save(aluno);
	}
	
	public void repositoryDeletarAluno(Aluno aluno) {
		
		alunoRepository.delete(aluno);
	}
	
	public Aluno repositoryEncontrarAluno(Integer alunoMatricula) {
		
		Aluno alunoRetorno = alunoRepository.findByMatricula(alunoMatricula);
		
		return alunoRetorno;
	}
	
	public Aluno criarAlunoModel(AlunoDto aluno) {
		
		Aluno alunoModel = new Aluno();
		
		alunoModel.setCpf(aluno.getCpf());
		alunoModel.setEmail(aluno.getEmail());
		alunoModel.setFormaIngresso(aluno.getFormaIngresso());
		alunoModel.setNome(aluno.getNome());
		alunoModel.setTurma(aluno.getTurma());
		
		return alunoModel;
	}
}
