package com.br.bgc.obras.applications.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarObraCommand(
        @NotNull
        @NotBlank
        String nome,
        String endereco
) {}
