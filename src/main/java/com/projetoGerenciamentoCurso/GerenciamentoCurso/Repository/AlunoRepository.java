package com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Aluno;



public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	Aluno findByMatricula(Integer matricula);
	
}
