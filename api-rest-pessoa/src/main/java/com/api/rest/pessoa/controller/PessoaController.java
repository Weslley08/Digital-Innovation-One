package com.api.rest.pessoa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.pessoa.dto.request.PessoaDto;
import com.api.rest.pessoa.dto.response.MensagemResponseDto;
import com.api.rest.pessoa.exceptions.PessoaNotFound;
import com.api.rest.pessoa.service.PessoaService;

import lombok.*;

@RestController
@RequestMapping("/api/v1/pessoa")
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class PessoaController {

	private PessoaService pessoaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public <MessagemResponseDto> MessagemResponseDto createPerson(@RequestBody @Valid PessoaDto pessoaDto) {
		return pessoaService.criarPessoa(pessoaDto);
	}

	@GetMapping
	public List<PessoaDto> listAll() {
		return pessoaService.listAll();
	}

	@GetMapping("/{id}")
	public PessoaDto findById(@PathVariable Long id) throws PessoaNotFound {
		return pessoaService.procurarPorId(id);
	}

	@PutMapping("/{id}")
	public MensagemResponseDto atualizarPorId(@PathVariable Long id, @RequestBody @Valid PessoaDto pessoaDto) throws PessoaNotFound {
		return pessoaService.atualizarPorId(id, pessoaDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PessoaNotFound {
		pessoaService.delete(id);
	}
}
