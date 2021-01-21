package com.projetoGerenciamentoCurso.gerenciamentoCurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Professor;


public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	Professor getOne(Integer id);


}
