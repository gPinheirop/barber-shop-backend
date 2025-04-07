package br.com.avanade.decolatech.barbershopbackend.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClientDetailResponse(
                @JsonProperty("id") Long id,
                @JsonProperty("name") String name,
                @JsonProperty("email") String email,
                @JsonProperty("phone") String phone) {
}
