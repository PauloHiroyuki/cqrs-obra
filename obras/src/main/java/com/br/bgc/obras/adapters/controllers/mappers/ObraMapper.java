package com.br.bgc.obras.adapters.controllers.mappers;

import com.br.bgc.obras.adapters.controllers.dtos.ObraDto;
import com.br.bgc.obras.domain.Obra;

import java.util.List;

public class ObraMapper {

    public static ObraDto toDto(Obra obra) {
        return ObraDto.builder()
                .endereco(obra.getEndereco())
                .id(obra.getId())
                .nome(obra.getNome())
                .build();
    }

    public static List<ObraDto> toDto(List<Obra> obras) {
        return obras.stream().map(ObraMapper::toDto).toList();
    }

}
