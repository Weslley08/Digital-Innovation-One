package com.api.rest.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.rest.pessoa.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}