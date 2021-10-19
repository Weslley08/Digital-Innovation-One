package com.api.rest.pessoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.api.rest.pessoa.enums.TipoTelefone;

import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoTelefone tipoTelefone;

	@Column(nullable = false)
	private String numero;
}
