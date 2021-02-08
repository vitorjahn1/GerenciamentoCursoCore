package com.projetoGerenciamentoCurso.GerenciamentoCurso.Controller;

import java.net.URI;

import javax.transaction.Transactional;

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

import com.projetogerenciamentocurso.gerenciamentocurso.models.Aluno;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.AlunoRepository;

@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.JVM)
@Transactional
 class AlunoControllerTest {

	@Autowired
	private AlunoRepository alunoRepository;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	 void criarAlunoRetornaSucesso() throws Exception {
		
		URI uri = new URI("/aluno");
		
		String json = "{\"idPessoa\":3,\"nome\":\"teste3\",\"cpf\":\"3333\",\"email\":\"teste3@teste3\",\"matricula\":3,\"formaIngresso\":\"vestibular3\"}";
		
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
	 void atualizarAlunoRetornaSucesso() throws Exception {
		
		criarAluno();
		
		URI uri = new URI("/aluno");
		
		String json = "{\"idPessoa\":3,\"nome\":\"teste3\",\"cpf\":\"4444\",\"email\":\"teste3@teste3\",\"matricula\":3,\"formaIngresso\":\"vestibular3\"}";
		
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
		
		criarAluno();
		
		URI uri = new URI("/aluno");
		
		String json = "{\"idPessoa\":3,\"nome\":\"teste3\",\"cpf\":\"4444\",\"email\":\"teste3@teste3\",\"matricula\":3,\"formaIngresso\":\"vestibular3\"}";
		
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	private void criarAluno() {
		
		Aluno alunoModel = new Aluno();
		alunoModel.setCpf("4444");
		alunoModel.setEmail("teste3@teste3");
		alunoModel.setFormaIngresso("vestibular3");
		alunoModel.setNome("teste3");
		alunoModel.setIdPessoa(3);
		alunoModel.setMatricula(3);
		
		alunoRepository.save(alunoModel);
	}
}
