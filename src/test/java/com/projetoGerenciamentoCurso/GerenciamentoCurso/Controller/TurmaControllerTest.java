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

import com.projetogerenciamentocurso.gerenciamentocurso.models.Turma;
import com.projetogerenciamentocurso.gerenciamentocurso.repository.TurmaRepository;

@SpringBootTest
@AutoConfigureMockMvc
class TurmaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TurmaRepository turmaRepository;

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
		
		Turma turmaModel = new Turma();
		
		turmaModel.setAnoLetivo("2");
		turmaModel.setDescricao("teste3");
		turmaModel.setNumeroVagas(20);
		turmaModel.setPeriodoLetivo(4);
		turmaModel.setAlunos(null);
		turmaModel.setDisciplinas(null);
		turmaModel.setIdTurma(3);
		turmaRepository.save(turmaModel);
	}

}
