package com.projetoGerenciamentoCurso.gerenciamentoCurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoGerenciamentoCurso.gerenciamentoCurso.models.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
