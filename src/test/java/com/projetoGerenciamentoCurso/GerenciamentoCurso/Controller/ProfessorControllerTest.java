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
class ProfessorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	private void criarProfessorRetornaSucesso() throws Exception {

		URI uri = new URI("/professor");

		String json = "{\"idPessoa\":3,\"nome\":\"teste\",\"cpf\":\"1111\",\"email\":\"teste@teste\",\"idProfessor\":3,\"titulacao\":\"mestre\"}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

	@Test
	private void atualizarProfessorRetornaSucesso() throws Exception {

		URI uri = new URI("/professor");

		String json = "{\"idPessoa\":1,\"nome\":\"teste\",\"cpf\":\"1111\",\"email\":\"teste2@teste2\",\"idProfessor\":1,\"titulacao\":\"mestre\"}";
		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));

	}
	
	
	@Test
	private void deletarProfessorRetornaSucesso() throws Exception {

		URI uri = new URI("/professor");

		String json = "{\"idPessoa\":3,\"nome\":\"teste\",\"cpf\":\"4444\",\"email\":\"teste@teste\",\"idProfessor\":3,\"titulacao\":\"doutor\"}";

		mockMvc.perform(MockMvcRequestBuilders.delete(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

}
