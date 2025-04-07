package br.com.avanade.decolatech.barbershopbackend.services;

import br.com.avanade.decolatech.barbershopbackend.entities.ClientEntity;

public interface IClientService {

    ClientEntity save(final ClientEntity entity);

    ClientEntity update(final ClientEntity entity);

    void delete(final long id);

}
