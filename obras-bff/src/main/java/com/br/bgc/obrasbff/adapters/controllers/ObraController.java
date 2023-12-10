package com.br.bgc.obrasbff.adapters.controllers;

import com.br.bgc.obrasbff.application.commands.AlterarObraCommand;
import com.br.bgc.obrasbff.application.commands.CriarObraCommand;
import com.br.bgc.obrasbff.application.dtos.ObraDto;
import com.br.bgc.obrasbff.application.services.ObraApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/obras")
public class ObraController {
    private final ObraApplicationService service;

    @GetMapping
    public ResponseEntity<List<ObraDto>> getAllObras() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<Void> post(@Valid @RequestBody CriarObraCommand command) {
        var obra = service.criar(command);
        var uri = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ObraController.class)
                .get(obra.id())).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable String id, @Valid @RequestBody AlterarObraCommand command) {
        service.alterar(id, command);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ObraDto> get(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
