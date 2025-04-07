package br.com.avanade.decolatech.barbershopbackend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avanade.decolatech.barbershopbackend.entities.ClientEntity;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {

    boolean existsByEmail(final String email);

    boolean existsByPhone(final String phone);

    Optional<ClientEntity> findByEmail(final String email);

    Optional<ClientEntity> findByPhone(final String phone);

}
