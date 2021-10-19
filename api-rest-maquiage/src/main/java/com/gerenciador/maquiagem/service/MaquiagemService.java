package com.gerenciador.maquiagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.maquiagem.dto.MaquiagemDTO;
import com.gerenciador.maquiagem.entity.Maquiagem;
import com.gerenciador.maquiagem.exception.MaquiagemAlreadyRegisteredException;
import com.gerenciador.maquiagem.mapper.MaquiagemMapper;
import com.gerenciador.maquiagem.repository.MaquiagemRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MaquiagemService {

	private final MaquiagemRepository maquiagemRepository;
	private final MaquiagemMapper maquiagemMapper = MaquiagemMapper.INSTANCE;

	public MaquiagemDTO criarMaquiagem(MaquiagemDTO maquiagemDTO) throws MaquiagemAlreadyRegisteredException {
		verifyIfIsAlreadyRegistered(maquiagemDTO.getNome());
		Maquiagem maquiagem = maquiagemMapper.toModel(maquiagemDTO);
		Maquiagem savedMaquiagem = maquiagemRepository.save(maquiagem);
		return maquiagemMapper.toDTO(savedMaquiagem);
	}

	public MaquiagemDTO findByNome(String nome) throws MaquiagemAlreadyRegisteredException {
	}
}
