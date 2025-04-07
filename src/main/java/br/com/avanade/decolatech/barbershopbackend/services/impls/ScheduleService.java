package br.com.avanade.decolatech.barbershopbackend.services.impls;

import org.springframework.stereotype.Service;

import br.com.avanade.decolatech.barbershopbackend.entities.ScheduleEntity;
import br.com.avanade.decolatech.barbershopbackend.repositories.IScheduleRepository;
import br.com.avanade.decolatech.barbershopbackend.services.IScheduleService;
import br.com.avanade.decolatech.barbershopbackend.services.queries.IScheduleQueryService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    private final IScheduleRepository repository;
    private final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(final ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());

        return repository.save(entity);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
