package com.br.bgc.obras.adapters.controllers.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ObraDto {
    private String id;
    private String nome;
    private String endereco;
}
