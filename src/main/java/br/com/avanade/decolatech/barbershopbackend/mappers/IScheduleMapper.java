package br.com.avanade.decolatech.barbershopbackend.mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.avanade.decolatech.barbershopbackend.controllers.requests.SaveScheduleRequest;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.ClientScheduleAppointmentResponse;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.SaveScheduleResponse;
import br.com.avanade.decolatech.barbershopbackend.controllers.responses.ScheduleAppointmentMonthResponse;
import br.com.avanade.decolatech.barbershopbackend.entities.ScheduleEntity;

@Mapper(componentModel = SPRING)
public interface IScheduleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client.id", source = "clientId")
    ScheduleEntity toEntity(final SaveScheduleRequest request);

    @Mapping(target = "clientId", source = "client.id")
    SaveScheduleResponse toSaveResponse(final ScheduleEntity entity);

    @Mapping(target = "scheduledAppointments", expression = "java(toClientMonthResponse(entities))")
    ScheduleAppointmentMonthResponse toMonthResponse(final int year, final int month,
            final List<ScheduleEntity> entities);

    List<ClientScheduleAppointmentResponse> toClientMonthResponse(final List<ScheduleEntity> entities);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "day", expression = "java(entity.getStartAt().getDayOfMonth())")
    ClientScheduleAppointmentResponse toClientMonthResponse(final ScheduleEntity entity);
}
