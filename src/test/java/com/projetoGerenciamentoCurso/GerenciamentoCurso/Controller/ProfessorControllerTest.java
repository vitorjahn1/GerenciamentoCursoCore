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

import com.projetogerenciamentocurso.gerenciamentocurso.models.Professor;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.ProfessorRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ProfessorControllerTest {

	@Autowired
	ProfessorRepository professorRepository; 
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void criarProfessorRetornaSucesso() throws Exception {

		URI uri = new URI("/professor");

		String json = "{\"idPessoa\":3,\"nome\":\"teste\",\"cpf\":\"1111\",\"email\":\"teste@teste\",\"idProfessor\":3,\"titulacao\":\"mestre\",\"disciplina\":null}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

	@Test
	void atualizarProfessorRetornaSucesso() throws Exception {
		
		criarProfessor();
		
		URI uri = new URI("/professor");

		String json ="{\"idPessoa\":3,\"nome\":\"teste\",\"cpf\":\"1111\",\"email\":\"teste@teste2\",\"idProfessor\":3,\"titulacao\":\"mestre\",\"disciplina\":null}";
		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));

	}
	
	
	@Test
	void deletarProfessorRetornaSucesso() throws Exception {
		
		criarProfessor();
		
		URI uri = new URI("/professor");

		String json = "{\"idPessoa\":3,\"nome\":\"teste\",\"cpf\":\"1111\",\"email\":\"teste@teste\",\"idProfessor\":3,\"titulacao\":\"mestre\",\"disciplina\":null}";

		mockMvc.perform(MockMvcRequestBuilders.delete(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}
	
	private void criarProfessor() {
		
		Professor professor = new Professor();
		
		professor.setCpf("1111");
		professor.setEmail("teste@teste");
		professor.setNome("teste");
		professor.setTitulacao("doutor");
		professor.setIdProfessor(3);
		professor.setIdPessoa(3);
		professorRepository.save(professor);
	}

}
