package com.api.rest.pessoa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.api.rest.pessoa.dto.request.PessoaDto;

@Mapper
public interface PessoaMapper {

	PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

	@Mapping(target = "data_de_nascimento", source = "data_de_nascimento", dateFormat = "dd-MM-yyyy")
	@SuppressWarnings("unused")
	static PessoaDto toModel(PessoaDto pessoaDto) {
		return null;
	}

	PessoaDto toDTO(PessoaDto pessoaDto);
}
