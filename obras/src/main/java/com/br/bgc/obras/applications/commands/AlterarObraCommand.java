package com.br.bgc.obras.applications.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlterarObraCommand(
        @NotNull
        @NotBlank
        String nome,
        String endereco
) {}
