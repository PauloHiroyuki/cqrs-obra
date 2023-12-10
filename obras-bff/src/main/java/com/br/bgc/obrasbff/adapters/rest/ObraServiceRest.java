package com.br.bgc.obrasbff.adapters.rest;

import com.br.bgc.obrasbff.application.dtos.ObraDto;
import com.br.bgc.obrasbff.application.interfaces.ObraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraServiceRest implements ObraService {

    

    @Override
    public List<ObraDto> listar() {
        return null;
    }

    @Override
    public ObraDto buscarPorId(String id) {
        return null;
    }
}
