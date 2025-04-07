package br.com.avanade.decolatech.barbershopbackend.repositories;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avanade.decolatech.barbershopbackend.entities.ScheduleEntity;

@Repository
public interface IScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

    List<ScheduleEntity> findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(
            final OffsetDateTime startAt,
            final OffsetDateTime endAt);

    boolean existsByStartAtAndEndAt(final OffsetDateTime startAt, final OffsetDateTime endAt);

}
