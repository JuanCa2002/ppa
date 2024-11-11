package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airport;

import com.puntopago.ppa.domain.enums.AirportState;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportResponse {

    @Schema(description = "Airport unique id")
    private Long id;

    @Schema(description = "Airport name")
    private String name;

    @Schema(description = "Airport address")
    private String address;

    @Schema(description = "Airport state")
    private AirportState state;

    @Schema(description = "Airport location (Municipality) unique id")
    private Long locationId;
}
