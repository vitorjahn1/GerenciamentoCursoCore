package com.projetoGerenciamentoCurso.gerenciamentoCurso.service;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.dto.AlunoDto;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Aluno;
import com.projetoGerenciamentoCurso.gerenciamentoCurso.repository.AlunoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class AlunoService {

	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno retornaAluno(AlunoDto aluno) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY, aluno);
		
		Aluno alunoModel = alunoRepository.save(criarAlunoModel(aluno));
		
		return alunoModel;

	}

	public Aluno deletarAluno(AlunoDto aluno) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY_ALUNO_DELETAR, aluno);
		
		Aluno alunoModel = alunoRepository.getOne(aluno.getMatricula());
		if(alunoModel!=null) {
			 
			alunoRepository.delete(alunoModel);
		}
		
		return alunoModel;
	}
	
	public Aluno atualizarAluno(AlunoDto aluno) {

		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,
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
