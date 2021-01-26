package com.projetogerenciamentocurso.gerenciamentocurso.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.GerenciamentoCursoApplication;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.AlunoDto;
import com.projetogerenciamentocurso.gerenciamentocurso.mensageria.Publisher;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Aluno;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.AlunoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class AlunoService {
	
	@Autowired
	private Publisher publisher;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno retornaAluno(AlunoDto aluno) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY, aluno);
		
		Aluno alunoModel = alunoRepository.save(criarAlunoModel(aluno));
		
		return alunoModel;

	}

	public Aluno deletarAluno(AlunoDto aluno) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY_ALUNO_DELETAR, aluno);
		
		Aluno alunoModel = alunoRepository.getOne(aluno.getMatricula());
		if(alunoModel!=null) {
			 
			alunoRepository.delete(alunoModel);
		}
		
		return alunoModel;
	}
	
	public Aluno atualizarAluno(AlunoDto aluno) {

		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY_ALUNO, aluno);
		
		Aluno alunoModel = alunoRepository.getOne(aluno.getMatricula());
		if (alunoModel != null) {

			alunoModel.setCpf(aluno.getCpf());
			alunoModel.setEmail(aluno.getEmail());
			alunoModel.setFormaIngresso(aluno.getFormaIngresso());
			alunoModel.setNome(aluno.getNome());
			alunoModel.setTurma(aluno.getTurma());
			
			alunoRepository.save(alunoModel);
		}
		return alunoModel;
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
