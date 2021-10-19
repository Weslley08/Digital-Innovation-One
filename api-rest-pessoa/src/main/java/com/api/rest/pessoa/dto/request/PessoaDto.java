package com.api.rest.pessoa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {

	private Long idPessoa;

	@NotEmpty
	@Size(min = 3, max = 20)
	private String primeroNome;

	@NotEmpty
	@Size(min = 3, max = 20)
	private String sobrenome;

	private String data_de_nascimento;

	@Valid
	@NotEmpty
	private List<TelefoneDto> telefones;

}
