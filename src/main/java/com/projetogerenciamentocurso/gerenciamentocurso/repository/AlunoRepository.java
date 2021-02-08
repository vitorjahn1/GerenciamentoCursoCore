package com.projetogerenciamentocurso.gerenciamentocurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Aluno;





public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	Aluno findByMatricula(Integer matricula);
	
}
