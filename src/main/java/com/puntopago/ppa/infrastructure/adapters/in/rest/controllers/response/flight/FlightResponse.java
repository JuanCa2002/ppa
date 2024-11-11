package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.flight;

import com.puntopago.ppa.domain.enums.FlightState;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightResponse {

    @Schema(description = "Flight unique id")
    private Long id;

    @Schema(description = "Flight price")
    private Double price;

    @Schema(description = "Flight itinerary unique id")
    private Long itineraryId;

    @Schema(description = "Flight airplane unique id")
    private Long airplaneId;

    @Schema(description = "Flight state")
    private FlightState state;

}
