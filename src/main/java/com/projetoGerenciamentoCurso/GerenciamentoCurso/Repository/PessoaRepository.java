package com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
