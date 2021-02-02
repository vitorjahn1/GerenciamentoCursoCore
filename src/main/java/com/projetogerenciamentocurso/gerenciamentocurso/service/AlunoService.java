package com.projetogerenciamentocurso.gerenciamentocurso.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.GerenciamentoCursoApplication;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.AlunoDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.AlunoDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.exceptions.AlunoException;
import com.projetogerenciamentocurso.gerenciamentocurso.mensageria.Publisher;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Aluno;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.AlunoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class AlunoService {
	
	private final Publisher publisher;
	
	private final AlunoRepository alunoRepository;
	
	public AlunoDtoResposta deletarAluno(AlunoDto aluno) {
		
		if(aluno!=null) {
			 
			alunoRepository.delete(alunoRepository.findByMatricula(aluno.getMatricula()));
		}else {
			throw new AlunoException("Aluno não encontrado");
		}
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY_ALUNO_DELETAR, aluno);
		
		return criarAlunoDtoResposta(aluno);
	}
	
	public AlunoDtoResposta atualizarAluno(AlunoDto aluno) {

		Aluno alunoModel = alunoRepository.findByMatricula(aluno.getMatricula());
		if (alunoModel != null) {

			alunoModel.setCpf(aluno.getCpf());
			alunoModel.setEmail(aluno.getEmail());
			alunoModel.setFormaIngresso(aluno.getFormaIngresso());
			alunoModel.setNome(aluno.getNome());
			alunoModel.setTurma(aluno.getTurma());
			
			alunoRepository.save(alunoModel);
		}else {
			throw new AlunoException("Aluno não encontrado");
		}
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY_ALUNO, aluno);
		
		return criarAlunoDtoResposta(aluno);
	}
	
	private void salvarAlunoDto(AlunoDto aluno) {
		
		Aluno alunoModel = new Aluno();
		
		alunoModel.setCpf(aluno.getCpf());
		alunoModel.setEmail(aluno.getEmail());
		alunoModel.setFormaIngresso(aluno.getFormaIngresso());
		alunoModel.setNome(aluno.getNome());
		alunoModel.setTurma(aluno.getTurma());
		alunoModel.setIdPessoa(aluno.getIdPessoa());
		alunoModel.setMatricula(aluno.getMatricula());
		
		alunoRepository.save(alunoModel);
	}
	
	public AlunoDtoResposta criarAluno(AlunoDto aluno) {
		
		AlunoDtoResposta alunoDtoResposta = criarAlunoDtoResposta(aluno);
		
		salvarAlunoDto(aluno);
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
				GerenciamentoCursoApplication.ROUTING_KEY, aluno);
		
		return alunoDtoResposta;
	}
	
	private AlunoDtoResposta criarAlunoDtoResposta(AlunoDto aluno) {
		
	AlunoDtoResposta alunoDtoResposta = new AlunoDtoResposta();
		
		alunoDtoResposta.setCpf(aluno.getCpf());
		alunoDtoResposta.setEmail(aluno.getEmail());
		alunoDtoResposta.setFormaIngresso(aluno.getFormaIngresso());
		alunoDtoResposta.setNome(aluno.getNome());
		alunoDtoResposta.setTurma(aluno.getTurma());
		alunoDtoResposta.setIdPessoa(aluno.getIdPessoa());
		alunoDtoResposta.setMatricula(aluno.getMatricula());
		return alunoDtoResposta;
	}
	
}
