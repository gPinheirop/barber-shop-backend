package br.com.avanade.decolatech.barbershopbackend.controllers.responses;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SaveScheduleResponse(
                @JsonProperty("id") Long id,
                @JsonProperty("startAt") OffsetDateTime startAt,
                @JsonProperty("endAt") OffsetDateTime endAt,
                @JsonProperty("clientId") Long clientId) {
}
