package com.br.bgc.obras.adapters.controllers;

import com.br.bgc.obras.adapters.controllers.dtos.ObraDto;
import com.br.bgc.obras.adapters.controllers.mappers.ObraMapper;
import com.br.bgc.obras.applications.commands.AlterarObraCommand;
import com.br.bgc.obras.applications.commands.CriarObraCommand;
import com.br.bgc.obras.applications.services.ObraApplicationService;
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
        var lista = service.listar();
        return ResponseEntity.ok(ObraMapper.toDto(lista));
    }

    @PostMapping
    public ResponseEntity<Void> post(@Valid @RequestBody CriarObraCommand command) {
        var obra = service.criar(command);
        var uri = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ObraController.class)
                .get(obra.getId())).toUri();
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
        var obra = service.buscarPorId(id);
        return obra.map(value -> ResponseEntity.ok(ObraMapper.toDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
