package com.api.rest.pessoa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.pessoa.dto.request.PessoaDto;
import com.api.rest.pessoa.entity.Pessoa;
import com.api.rest.pessoa.exceptions.PessoaNotFound;
import com.api.rest.pessoa.mapper.PessoaMapper;
import com.api.rest.pessoa.repository.PessoaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

	private PessoaRepository pessoaRepository;

	private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

	// Metodo para criar uma pessoa
	public <MessagemResponseDto> MessagemResponseDto criarPessoa(PessoaDto pessoaDto) {
		Pessoa salvarPessoa = PessoaMapper.toModel(pessoaDto);

		Pessoa pessoaSalva = pessoaRepository.save(salvarPessoa);
		return createMessageResponse(pessoaSalva.getIdPessoa(), "Pessoa criada com sucesso");
	}

	public List<PessoaDto> listAll() {
		List<Pessoa> allPeople = pessoaRepository.findAll();
		return allPeople.stream().map(pessoaMapper::toDTO).collect(Collectors.toList());
	}

	
	public PessoaDto procurarPorId(Long id) throws PessoaNotFound {
		Pessoa pessoa = verifyIfExists(id);
		return pessoaMapper.toDTO(Pessoa);
	}

	public void delete(Long id) throws PessoaNotFound {
		verifyIfExists(id);
		pessoaRepository.deleteById(id);
	}

	// Metodo para atualizar
	public <MessagemResponseDto> MessagemResponseDto  atualizarPorId(Long id, PessoaDto pessoaDto) throws PessoaNotFound {
		verifyIfExists(id);

		Pessoa atualizarPessoa = PessoaMapper.toModel(pessoaDto);

		Pessoa pessoaAtualizada = pessoaRepository.save(atualizarPessoa);
		return createMessageResponse(pessoaAtualizada.getIdPessoa(), "Pessoa atualizada com sucesso");
	}

	
	// Metodo para verificar se existe
	private Pessoa verifyIfExists(Long id) throws PessoaNotFound {
		return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFound(id));
	}

	private <MessagemResponseDto> MessagemResponseDto  createMessageResponse(Long id, String message) {
		return MessagemResponseDto.builder().message(message + id).build();
	}
}
