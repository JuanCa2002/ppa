package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airline;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirlineRequest {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    @Schema(description = "Airline name")
    private String name;
}
