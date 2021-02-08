package com.projetogerenciamentocurso.gerenciamentocurso.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.GerenciamentoCursoApplication;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.AlunoDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.DisciplinaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.TurmaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.AlunoDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.DisciplinaDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.dtoresposta.TurmaDtoResposta;
import com.projetogerenciamentocurso.gerenciamentocurso.exceptions.TurmaException;
import com.projetogerenciamentocurso.gerenciamentocurso.mensageria.Publisher;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Aluno;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Disciplina;
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
		try {
			Turma turmaModel = turmaRepository.getOne(turmaDto.getIdTurma());
			
			turmaModel.setAnoLetivo(turmaDto.getAnoLetivo());
			turmaModel.setDescricao(turmaDto.getDescricao());
			turmaModel.setNumeroVagas(turmaDto.getNumeroVagas());
			turmaModel.setPeriodoLetivo(turmaDto.getPeriodoLetivo());
			turmaModel.setAlunos(criarListaAlunoModel(turmaDto.getAlunos()));
			turmaModel.setDisciplinas(criarListaDisciplinaModel(turmaDto.getDisciplinas()));
			turmaModel.setIdTurma(turmaDto.getIdTurma());
			turmaRepository.save(turmaModel);
		}catch (EntityNotFoundException e) {
			throw new TurmaException("Turma não encontrada");
		}
			
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME,
					GerenciamentoCursoApplication.ROUTING_TURMA_ATUALIZAR, turmaDto);
		
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
		
		try {
			Turma turmaDelatar = turmaRepository.getOne(turma.getIdTurma());
			
			turmaRepository.delete(turmaDelatar);
		}catch (EntityNotFoundException e) {
			throw new TurmaException("Turma não encontrada");
		}
		
		publisher.send(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_TURMA_DELETAR,
					turma);
	
		return criarTurmaDtoResposta(turma);
	}

	private Turma criarModelTurma(TurmaDto turmaDto) {

		Turma turma = new Turma();
		
		turma.setAnoLetivo(turmaDto.getAnoLetivo());
		turma.setDescricao(turmaDto.getDescricao());
		turma.setNumeroVagas(turmaDto.getNumeroVagas());
		turma.setPeriodoLetivo(turmaDto.getPeriodoLetivo());
		turma.setIdTurma(turmaDto.getIdTurma());
		turma.setAlunos(null);
		turma.setDisciplinas(null);
		return turma;
	}

	private TurmaDtoResposta criarTurmaDtoResposta(TurmaDto turmaDto) {
		
		TurmaDtoResposta turma = new TurmaDtoResposta();
		turma.setDisciplinas(criarListaDisciplinaDtoResposta(turmaDto.getDisciplinas()));
		turma.setAlunos(criarListaAlunoDtoResposta(turmaDto.getAlunos()));
		turma.setAnoLetivo(turmaDto.getAnoLetivo());
		turma.setDescricao(turmaDto.getDescricao());
		turma.setNumeroVagas(turmaDto.getNumeroVagas());
		turma.setPeriodoLetivo(turmaDto.getPeriodoLetivo());
		turma.setIdTurma(turmaDto.getIdTurma());
		return turma;
	}
	
	private Set<AlunoDtoResposta> criarListaAlunoDtoResposta(Set<AlunoDto> alunoDtos){
		
		
		
		Set<AlunoDtoResposta> alunosResposta = new HashSet<>();
		
		if(alunoDtos!= null && !alunoDtos.isEmpty()) {
			
			for(AlunoDto alunoDto : alunoDtos) {
				AlunoDtoResposta alunoResposta= new AlunoDtoResposta();
				alunoResposta.setCpf(alunoDto.getCpf());
				alunoResposta.setEmail(alunoDto.getEmail());
				alunoResposta.setFormaIngresso(alunoDto.getFormaIngresso());
				alunoResposta.setNome(alunoDto.getNome());
				alunoResposta.setIdPessoa(alunoDto.getIdPessoa());
				alunoResposta.setMatricula(alunoDto.getMatricula());
				
				alunosResposta.add(alunoResposta);
			}
			return alunosResposta;
		}else {
			
			return alunosResposta;
		}
		
		
		
	}
	
	private Set<DisciplinaDtoResposta> criarListaDisciplinaDtoResposta(Set<DisciplinaDto> disciplinasDto){
		
		Set<DisciplinaDtoResposta> disciplinasRespostas = new HashSet<>();
		
		if(!disciplinasDto.isEmpty()) {
			
			for(DisciplinaDto disciplinaDto : disciplinasDto) {
				DisciplinaDtoResposta disciplinaDtoResposta = new DisciplinaDtoResposta();
				
				disciplinaDtoResposta.setIdDisciplina(disciplinaDto.getIdDisciplina());
				disciplinaDtoResposta.setDescricao(disciplinaDto.getDescricao());
				disciplinaDtoResposta.setCargaHoraria(disciplinaDto.getCargaHoraria());
				disciplinaDtoResposta.setSigla(disciplinaDto.getSigla());
				
				disciplinasRespostas.add(disciplinaDtoResposta);
			}
			
			return disciplinasRespostas;
		}else {
			
			return disciplinasRespostas;
		}
		
		
		
		
	}
	
	private Set<Aluno> criarListaAlunoModel(Set<AlunoDto> alunoDtos){
		
		Set<Aluno> alunosResposta = new HashSet<>();
		
		if(alunoDtos!= null && !alunoDtos.isEmpty()) {
			
			for(AlunoDto alunoDto : alunoDtos) {
				
				Aluno aluno= new Aluno();
				
				aluno.setCpf(alunoDto.getCpf());
				aluno.setEmail(alunoDto.getEmail());
				aluno.setFormaIngresso(alunoDto.getFormaIngresso());
				aluno.setNome(alunoDto.getNome());
				aluno.setIdPessoa(alunoDto.getIdPessoa());
				aluno.setMatricula(alunoDto.getMatricula());
				
				alunosResposta.add(aluno);
			}
			return alunosResposta;
		}else {
			
			return alunosResposta;
		}
		
	}
	
	private Set<Disciplina> criarListaDisciplinaModel(Set<DisciplinaDto> disciplinasDto){
		
		Set<Disciplina> disciplinasRespostas = new HashSet<>();
		
		if(!disciplinasDto.isEmpty()) {
			
			for(DisciplinaDto disciplinaDto : disciplinasDto) {
				Disciplina disciplina = new Disciplina();
				
				disciplina.setIdDisciplina(disciplinaDto.getIdDisciplina());
				disciplina.setDescricao(disciplinaDto.getDescricao());
				disciplina.setCargaHoraria(disciplinaDto.getCargaHoraria());
				disciplina.setSigla(disciplinaDto.getSigla());
				
				disciplinasRespostas.add(disciplina);
			}
			
			return disciplinasRespostas;
		}else {
			
			return disciplinasRespostas;
		}
	}
}
