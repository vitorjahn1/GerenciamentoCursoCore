package com.projetoGerenciamentoCurso.GerenciamentoCurso.Controller;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Aluno;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Disciplina;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Professor;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Turma;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.AlunoRepository;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.DisciplinaRepository;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.ProfessorRepository;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.TurmaRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class TurmaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private AlunoRepository alunorepository;

	@Test
	void criarTurmaRetornaSucesso() throws Exception {

		URI uri = new URI("/turma");

		String json = "{\"idTurma\":3,\"anoLetivo\":\"2\",\"descricao\":\"teste\",\"numeroVagas\":20,\"periodoLetivo\":4,\"disciplinas\":[{\"idDisciplina\":1,\"descricao\":\"teste\",\"cargaHoraria\":\"10\",\"sigla\":\"tes\",\"professoeres\":[]}]}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

	@Test
	void atualizarTurmaRetornaSucesso() throws Exception {
		
		criarObjetoBanco();
		
		URI uri = new URI("/turma");

		String json = "{\"idTurma\":3,\"anoLetivo\":\"2\",\"descricao\":\"teste3\",\"numeroVagas\":20,\"periodoLetivo\":4,\"disciplinas\":[{\"idDisciplina\":1,\"descricao\":\"teste\",\"cargaHoraria\":\"10\",\"sigla\":\"tes\",\"professoeres\":[]}]}";

		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

	@Test
	void deletarTurmaRetornaSucesso() throws Exception {
		
		criarObjetoBanco();
		
		URI uri = new URI("/turma");
		String json = "{\"idTurma\":3,\"anoLetivo\":\"2\",\"descricao\":\"teste3\",\"numeroVagas\":20,\"periodoLetivo\":4,\"disciplinas\":[{\"idDisciplina\":1,\"descricao\":\"teste\",\"cargaHoraria\":\"10\",\"sigla\":\"tes\",\"professoeres\":[]}]}";

		mockMvc.perform(MockMvcRequestBuilders.delete(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status()
				.is(200));

	}
	
	private void criarObjetoBanco() {
		
		Professor professor = new Professor();
		
		professor.setCpf("1111");
		professor.setEmail("teste@teste");
		professor.setIdPessoa(1);
		professor.setNome("teste");
		professor.setTitulacao("mestrado");
		professor.setIdProfessor(1);
		
		professorRepository.saveAndFlush(professor);
		
		Disciplina disciplina = new Disciplina();
		
		disciplina.setCargaHoraria("10");
		disciplina.setDescricao("teste");
		disciplina.setIdDisciplina(1);
		disciplina.setProfessor(professor);
		disciplina.setSigla("tes");
		
		disciplinaRepository.saveAndFlush(disciplina);
		
		Set<Disciplina> disciplinas = new HashSet<>();
		disciplinas.add(disciplina);
		
		Aluno aluno = new Aluno();
		
		aluno.setCpf("1111");
		aluno.setEmail("teste@teste");
		aluno.setIdPessoa(1);
		aluno.setNome("teste");
		aluno.setMatricula(1);
		aluno.setFormaIngresso("vestibular");
		
		alunorepository.saveAndFlush(aluno);
		
		Set<Aluno> alunos = new HashSet<>();
		alunos.add(aluno);
		
		Turma turmaModel = new Turma();
		
		turmaModel.setAnoLetivo("2");
		turmaModel.setDescricao("teste3");
		turmaModel.setNumeroVagas(20);
		turmaModel.setPeriodoLetivo(4);
		turmaModel.setAlunos(alunos);
		turmaModel.setDisciplinas(disciplinas);
		turmaModel.setIdTurma(3);
		turmaRepository.save(turmaModel);
	}

}
