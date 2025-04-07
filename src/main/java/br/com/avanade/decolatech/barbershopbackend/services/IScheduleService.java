package br.com.avanade.decolatech.barbershopbackend.services;

import br.com.avanade.decolatech.barbershopbackend.entities.ScheduleEntity;

public interface IScheduleService {

    ScheduleEntity save(final ScheduleEntity entity);

    void delete(final long id);

}
