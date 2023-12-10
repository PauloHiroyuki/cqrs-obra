package com.br.bgc.obras.applications.services;

import com.br.bgc.obras.applications.commands.AlterarObraCommand;
import com.br.bgc.obras.applications.commands.CriarObraCommand;
import com.br.bgc.obras.applications.interfaces.ObraRepository;
import com.br.bgc.obras.domain.Obra;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObraApplicationService {

    private final ObraRepository repository;

    @Transactional
    public Obra criar(CriarObraCommand command) {
        var obra = Obra.builder()
                .nome(command.nome())
                .endereco(command.endereco())
                .build();

        return repository.salvar(obra);
    }

    @Transactional
    public void alterar(String id, AlterarObraCommand command) {
        var obra = repository.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Não foi encontrado obra com id " + id));
        obra.setEndereco(command.endereco());
        obra.setNome(command.nome());
        repository.salvar(obra);
    }

    @Transactional
    public void deletar(String id) {
        repository.deletar(id);
    }

    public Optional<Obra> buscarPorId(String id) {
        return repository.buscarPorId(id);
    }

    public List<Obra> listar() {
        return repository.listar();
    }
}
