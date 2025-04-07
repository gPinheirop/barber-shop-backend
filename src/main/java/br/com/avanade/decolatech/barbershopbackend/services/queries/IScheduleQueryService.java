package br.com.avanade.decolatech.barbershopbackend.services.queries;

import java.time.OffsetDateTime;
import java.util.List;

import br.com.avanade.decolatech.barbershopbackend.entities.ScheduleEntity;

public interface IScheduleQueryService {

    ScheduleEntity findById(final long id);

    List<ScheduleEntity> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt);

    void verifyIfScheduleExists(final OffsetDateTime startAt, final OffsetDateTime endAt);

}
