package com.br.bgc.obrasbff.application.interfaces;

import com.br.bgc.obrasbff.application.dtos.ObraDto;

import java.util.List;

public interface ObraService {
    List<ObraDto> listar();

    ObraDto buscarPorId(String id);
}
