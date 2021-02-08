package com.projetoGerenciamentoCurso.GerenciamentoCurso.Controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Disciplina;
import com.projetogerenciamentocurso.gerenciamentocurso.models.Professor;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.DisciplinaRepository;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.ProfessorRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class DisciplinaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Test
	 void criarDisciplinaRetornaSucesso() throws Exception {

		URI uri = new URI("/disciplina");

		String json = "{\"idDisciplina\":4,\"descricao\":\"teste4\",\"cargaHoraria\":\"10\",\"sigla\":\"tes\"}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

	@Test
	 void atualizarDisciplinaRetornaSucesso() throws Exception {

		incluirObjetoNobanco();
		
		URI uri = new URI("/disciplina");
		
		String json = "{\"idDisciplina\":4,\"descricao\":\"teste3\",\"cargaHoraria\":\"13\",\"sigla\":\"tes\"}";

		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}

	@Test
	 void deletarDisciplinaRetornaSucesso() throws Exception {
		
		incluirObjetoNobanco();
		
		URI uri = new URI("/disciplina");
		String json = "{\"idDisciplina\":4,\"descricao\":\"teste4\",\"cargaHoraria\":\"10\",\"sigla\":\"tes3\"}";
		mockMvc.perform(MockMvcRequestBuilders.delete(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	private void incluirObjetoNobanco() {
		
		Professor professor = new Professor();
		professor.setCpf("1111");
		professor.setEmail("teste@teste");
		professor.setIdPessoa(1);
		professor.setIdProfessor(1);
		professor.setNome("teste");
		professor.setTitulacao("mestre");
		
		professorRepository.saveAndFlush(professor);
		
		Disciplina disciplina = new Disciplina();
		disciplina.setIdDisciplina(4);
		disciplina.setDescricao("teste4");
		disciplina.setCargaHoraria("10");
		disciplina.setSigla("tes3");
		disciplina.setProfessor(professor);
		disciplinaRepository.save(disciplina);
		
	}
	
}
