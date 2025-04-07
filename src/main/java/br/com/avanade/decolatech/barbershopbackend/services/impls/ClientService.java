package br.com.avanade.decolatech.barbershopbackend.services.impls;

import org.springframework.stereotype.Repository;

import br.com.avanade.decolatech.barbershopbackend.entities.ClientEntity;
import br.com.avanade.decolatech.barbershopbackend.repositories.IClientRepository;
import br.com.avanade.decolatech.barbershopbackend.services.IClientService;
import br.com.avanade.decolatech.barbershopbackend.services.queries.IClientQueryService;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository repository;
    private final IClientQueryService queryService;

    @Override
    public ClientEntity save(final ClientEntity entity) {
        queryService.verifyEmail(entity.getEmail());
        queryService.verifyPhone(entity.getPhone());

        return repository.save(entity);
    }

    @Override
    public ClientEntity update(final ClientEntity entity) {
        queryService.verifyEmail(entity.getId(), entity.getEmail());
        queryService.verifyPhone(entity.getId(), entity.getPhone());

        var stored = queryService.findById(entity.getId());
        stored.setName(entity.getName());
        stored.setPhone(entity.getPhone());
        stored.setEmail(entity.getEmail());
        return repository.save(stored);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
