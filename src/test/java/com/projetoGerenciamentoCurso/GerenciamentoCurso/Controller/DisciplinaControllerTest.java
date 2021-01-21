package com.projetoGerenciamentoCurso.GerenciamentoCurso.Controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class DisciplinaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	private void criarDisciplinaRetornaSucesso() throws Exception {

		URI uri = new URI("/disciplina");

		String json = "{\"idDisciplina\":4,\"descricao\":\"teste4\",\"cargaHoraria\":\"10\",\"sigla\":\"tes\",\"professoeres\":[{\"idPessoa\":1,\"nome\":\"teste\",\"cpf\":\"1111\",\"email\":\"teste@teste\",\"idProfessor\":1,\"titulacao\":\"mestre\"}]}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

	@Test
	private void atualizarDisciplinaRetornaSucesso() throws Exception {

		URI uri = new URI("/disciplina");

		String json = "{\"idDisciplina\":3,\"descricao\":\"teste3\",\"cargaHoraria\":\"13\",\"sigla\":\"tes\",\"professoeres\":[{\"idPessoa\":1,\"nome\":\"teste\",\"cpf\":\"1111\",\"email\":\"teste@teste\",\"idProfessor\":1,\"titulacao\":\"mestre\"}]}";

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
	private void deletarDisciplinaRetornaSucesso() throws Exception {

		URI uri = new URI("/disciplina");
		String json = "{\"idDisciplina\":4,\"descricao\":\"teste4\",\"cargaHoraria\":\"10\",\"sigla\":\"tes3\",\"professoeres\":[{\"idPessoa\":1,\"nome\":\"teste\",\"cpf\":\"1111\",\"email\":\"teste@teste\",\"idProfessor\":1,\"titulacao\":\"mestre\"}]}";
		mockMvc.perform(MockMvcRequestBuilders.delete(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

}
