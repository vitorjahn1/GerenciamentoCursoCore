package com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.RepositoryServices;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Dto.DisciplinaDto;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Disciplina;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository.DisciplinaRepository;

public class DisciplinaRepositoryService {
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	public void repositoryCriarDisciplina(Disciplina disciplina) {
		
		disciplinaRepository.save(disciplina);
	}
	
	public void repositoryAtualizarDisciplina(Disciplina disciplina) {
		
		disciplinaRepository.save(disciplina);
	}
	
	public void repositoryDeletarDisciplina(Disciplina disciplina) {
		
		disciplinaRepository.delete(disciplina);
	}
	
	public Disciplina repositoryEncontrarDisciplina(Integer idDisciplina) {
		
		Disciplina disciplinaRetorno = disciplinaRepository.getOne(idDisciplina);
		
		return disciplinaRetorno;
	}
	
	public Disciplina criarModelDisciplina(DisciplinaDto disciplinaDto) {
		
		Disciplina disciplianModel = new Disciplina();
		
		disciplianModel.setProfessores(disciplinaDto.getProfessores());
		disciplianModel.setDescricao(disciplinaDto.getDescricao());
		disciplianModel.setCargaHoraria(disciplinaDto.getCargaHoraria());
		disciplianModel.setSigla(disciplinaDto.getSigla());
		disciplianModel.setTurmas(disciplinaDto.getTurmas());
		
		return disciplianModel;
	}

}
