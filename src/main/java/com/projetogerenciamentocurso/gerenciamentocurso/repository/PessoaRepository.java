package com.projetogerenciamentocurso.gerenciamentocurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetogerenciamentocurso.gerenciamentocurso.models.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
