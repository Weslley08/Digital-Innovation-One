package com.api.rest.pessoa.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.api.rest.pessoa.enums.TipoTelefone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDto {
	
	private Long idTelefone;

	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;

	@NotEmpty
	@Size(min = 13, max = 15)
	private String numero;
}
