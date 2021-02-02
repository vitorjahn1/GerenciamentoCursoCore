package com.projetoGerenciamentoCurso.GerenciamentoCurso.Controller;

import java.net.URI;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.JVM)
public class AlunoControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void criarAlunoRetornaSucesso() throws Exception {
		
		
		
		URI uri = new URI("/aluno");
		
		String json = "{\"idPessoa\":3,\"nome\":\"teste3\",\"cpf\":\"3333\",\"email\":\"teste3@teste3\",\"matricula\":3,\"formaIngresso\":\"vestibular3\",\"turma\":[]}";
		
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
		
	}
	
	
	@Test
	public void atualizarAlunoRetornaSucesso() throws Exception {
		
		
		
		URI uri = new URI("/aluno");
		
		String json = "{\"idPessoa\":3,\"nome\":\"teste3\",\"cpf\":\"4444\",\"email\":\"teste3@teste3\",\"matricula\":3,\"formaIngresso\":\"vestibular3\",\"turma\":[]}";
		
		
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
	 void deletarAlunoRetornaSucesso() throws Exception {
		
		URI uri = new URI("/aluno");
		
		String json = "{\"idPessoa\":3,\"nome\":\"teste\",\"cpf\":\"1111\",\"email\":\"teste@teste\",\"idProfessor\":1,\"titulacao\":\"mestre\"}";
		
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
		
	}

}
