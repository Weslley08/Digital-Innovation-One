package com.gerenciador.maquiagem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.maquiagem.entity.Maquiagem;

public interface MaquiagemRepository extends JpaRepository<Maquiagem, Long> {
	
	Optional<Maquiagem> findByName(String nome);

}
