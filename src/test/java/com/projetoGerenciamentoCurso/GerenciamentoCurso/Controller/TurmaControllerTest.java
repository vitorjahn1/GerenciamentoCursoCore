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
class TurmaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	private void criarTurmaRetornaSucesso() throws Exception {

		URI uri = new URI("/turma");

		String json = "{\"idTurma\":3,\"anoLetivo\":\"2\",\"descricao\":\"teste\",\"numeroVagas\":20,\"periodoLetivo\":4,\"disciplinas\":[{\"idDisciplina\":1,\"descricao\":\"teste\",\"cargaHoraria\":\"10\",\"sigla\":\"tes\",\"professoeres\":[]}]}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

	@Test
	private void atualizarTurmaRetornaSucesso() throws Exception {

		URI uri = new URI("/turma");

		String json = "{\"idTurma\":3,\"anoLetivo\":\"2\",\"descricao\":\"teste3\",\"numeroVagas\":20,\"periodoLetivo\":4,\"disciplinas\":[{\"idDisciplina\":1,\"descricao\":\"teste\",\"cargaHoraria\":\"10\",\"sigla\":\"tes\",\"professoeres\":[]}]}";

		mockMvc.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

	@Test
	private void deletarTurmaRetornaSucesso() throws Exception {

		URI uri = new URI("/turma");
		String json = "{\"idTurma\":3,\"anoLetivo\":\"2\",\"descricao\":\"teste3\",\"numeroVagas\":20,\"periodoLetivo\":4,\"disciplinas\":[{\"idDisciplina\":1,\"descricao\":\"teste\",\"cargaHoraria\":\"10\",\"sigla\":\"tes\",\"professoeres\":[]}]}";

		mockMvc.perform(MockMvcRequestBuilders.delete(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status()
				.is(200));

	}

}
