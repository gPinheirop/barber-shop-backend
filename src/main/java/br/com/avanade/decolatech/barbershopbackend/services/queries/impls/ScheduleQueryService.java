package br.com.avanade.decolatech.barbershopbackend.services.queries.impls;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.avanade.decolatech.barbershopbackend.entities.ScheduleEntity;
import br.com.avanade.decolatech.barbershopbackend.exceptions.NotFoundException;
import br.com.avanade.decolatech.barbershopbackend.exceptions.ScheduleInUseException;
import br.com.avanade.decolatech.barbershopbackend.repositories.IScheduleRepository;
import br.com.avanade.decolatech.barbershopbackend.services.queries.IScheduleQueryService;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ScheduleQueryService implements IScheduleQueryService {

    private final IScheduleRepository repository;

    @Override
    public ScheduleEntity findById(final long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Agendamento não encontrado"));
    }

    @Override
    public List<ScheduleEntity> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt) {
        return repository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }

    @Override
    public void verifyIfScheduleExists(final OffsetDateTime startAt, final OffsetDateTime endAt) {
        if (repository.existsByStartAtAndEndAt(startAt, endAt)) {
            var message = "Já existe um cliente agendado no horário solicitado";
            throw new ScheduleInUseException(message);
        }
    }

}
