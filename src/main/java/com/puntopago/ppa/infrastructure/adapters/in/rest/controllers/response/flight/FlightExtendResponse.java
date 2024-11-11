package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.flight;

import com.puntopago.ppa.domain.enums.UnitTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightExtendResponse extends FlightResponse{

    @Schema(description = "Flight municipality origin name")
    private String municipalityOriginName;

    @Schema(description = "Flight estimated time")
    private Integer estimatedTime;

    @Schema(description = "Flight unit estimated time")
    private UnitTime unitTime;

    @Schema(description = "Flight municipality destiny name")
    private String municipalityDestinyName;
}
