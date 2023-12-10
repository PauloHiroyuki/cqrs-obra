package com.br.bgc.obrasbff.application.services;

import com.br.bgc.obrasbff.application.commands.AlterarObraCommand;
import com.br.bgc.obrasbff.application.commands.CriarObraCommand;
import com.br.bgc.obrasbff.application.dtos.ObraDto;
import com.br.bgc.obrasbff.application.interfaces.ObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ObraApplicationService {

    private final ObraService service;

    public List<ObraDto> listar() {
        return service.listar();
    }

    public ObraDto buscarPorId(String id) {
        return service.buscarPorId(id);
    }

    public void criar(CriarObraCommand command) {
    }

    public void alterar(String id, AlterarObraCommand command) {
    }

    public void deletar(String id) {
    }
}
