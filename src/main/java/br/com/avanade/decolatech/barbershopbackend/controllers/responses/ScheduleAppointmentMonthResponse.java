package br.com.avanade.decolatech.barbershopbackend.controllers.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ScheduleAppointmentMonthResponse(
                @JsonProperty("year") int year,
                @JsonProperty("month") int month,
                List<ClientScheduleAppointmentResponse> scheduledAppointments) {
}
