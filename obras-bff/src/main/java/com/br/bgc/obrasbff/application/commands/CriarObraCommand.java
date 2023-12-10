package com.br.bgc.obrasbff.application.commands;

import jakarta.validation.constraints.NotBlank;

public record CriarObraCommand(
        @NotBlank
        String nome,
        String endereco
) {}
