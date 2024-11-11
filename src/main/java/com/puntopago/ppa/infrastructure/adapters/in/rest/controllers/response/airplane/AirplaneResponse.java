package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airplane;

import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airline.AirlineResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirplaneResponse {

    @Schema(description = "Airplane unique id")
    private Long id;

    @Schema(description = "Airplane branch")
    private String branch;

    @Schema(description = "Airplane model")
    private Integer model;

    @Schema(description = "Airplane state")
    private State state;

    @Schema(description = "Airplane airline")
    private AirlineResponse airline;
}
