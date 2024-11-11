package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airline;

import com.puntopago.ppa.domain.enums.State;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirlineResponse {

    @Schema(description = "Arline unique id")
    private Long id;

    @Schema(description = "Arline name")
    private String name;

    @Schema(description = "Arline state")
    private State state;
}
