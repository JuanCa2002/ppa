package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightRequest {

    @NotNull
    @Min(value = 1)
    @Schema(description = "Flight price")
    private Double price;

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Flight itinerary unique id")
    private Long itineraryId;

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Flight airplane unique id")
    private Long airplaneId;
}
