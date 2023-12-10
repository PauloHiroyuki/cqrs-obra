package com.br.bgc.obras.adapters.postgres;

import com.br.bgc.obras.applications.interfaces.ObraRepository;
import com.br.bgc.obras.domain.Obra;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ObraRepositoryPostgres implements ObraRepository {

    private final EntityManager entityManager;

    @Override
    public Obra salvar(Obra obra) {
        Obra result = entityManager.merge(obra);
        flushAndClear();
        return result;
    }

    @Override
    public void deletar(String idObra) {
        var result = entityManager.find(Obra.class, idObra);
        entityManager.remove(result);
        flushAndClear();
    }

    @Override
    public Optional<Obra> buscarPorId(String id) {
        return Optional.ofNullable(entityManager.find(Obra.class, id));
    }

    @Override
    public List<Obra> listar() {
        return entityManager
                .createQuery("from Obra", Obra.class)
                .getResultList();
    }

    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }
}
