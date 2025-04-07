package br.com.avanade.decolatech.barbershopbackend.mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.avanade.decolatech.barbershopbackend.controllers.requests.SaveClientRequest;
import br.com.avanade.decolatech.barbershopbackend.controllers.requests.UpdateClientRequest;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.ClientDetailResponse;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.ListClientResponse;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.SaveClientResponse;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.UpdateClientResponse;
import br.com.avanade.decolatech.barbershopbackend.entities.ClientEntity;

@Mapper(componentModel = SPRING)
public interface IClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);

}
