package com.projetogerenciamentocurso.gerenciamentocurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Professor;


public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	Professor getOne(Integer id);


}
