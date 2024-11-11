package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAirportRequest {

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Airport unique id")
    private Long id;

    @Size(min = 1, max = 80)
    @Schema(description = "Airport name")
    private String name;
}
