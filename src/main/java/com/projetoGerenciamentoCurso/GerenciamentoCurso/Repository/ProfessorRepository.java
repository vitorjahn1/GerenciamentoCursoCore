package com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	Professor getOne(Integer id);


}
