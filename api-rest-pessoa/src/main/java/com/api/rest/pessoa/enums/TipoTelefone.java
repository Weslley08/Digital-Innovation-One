package com.api.rest.pessoa.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoTelefone {

	PESSOAL("pessoal"),
	COMERCIAL("comercial"),
	ALTERNATIVO("alternativo");
	
	private final String tipo;
}
