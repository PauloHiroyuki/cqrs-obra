package com.br.bgc.obras.applications.interfaces;

import com.br.bgc.obras.applications.commands.AlterarObraCommand;
import com.br.bgc.obras.applications.commands.CriarObraCommand;
import com.br.bgc.obras.domain.Obra;

import java.util.List;
import java.util.Optional;

public interface ObraRepository {
    Obra salvar(Obra obra);
    void deletar(String idObra);
    Optional<Obra> buscarPorId(String id);
    List<Obra> listar();
}
