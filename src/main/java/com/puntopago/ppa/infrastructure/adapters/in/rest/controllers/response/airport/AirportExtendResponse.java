package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.airport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportExtendResponse extends AirportResponse {

    @Schema(description = "Airport location name (Municipality Name)")
    private String locationName;

    @Schema(description = "Airport department name")
    private String departmentName;

    @Schema(description = "Airport department unique id")
    private Long departmentId;
}
