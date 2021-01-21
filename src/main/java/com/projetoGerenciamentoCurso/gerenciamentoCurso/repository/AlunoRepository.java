package com.projetoGerenciamentoCurso.gerenciamentoCurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Aluno;





public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	Aluno findByMatricula(Integer matricula);
	
}
