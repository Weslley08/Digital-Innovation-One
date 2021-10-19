package com.api.rest.pessoa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public PessoaNotFound(Long id) {
		super("Person not found with ID " + id);
	}
}
