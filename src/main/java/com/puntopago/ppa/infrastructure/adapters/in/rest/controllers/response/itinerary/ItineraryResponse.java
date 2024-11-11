package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.itinerary;

import com.puntopago.ppa.domain.enums.UnitTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ItineraryResponse {

    @Schema(description = "Itinerary unique id")
    private Long id;

    @Schema(description = "Itinerary origin (Municipality) unique id")
    private Long originId;

    @Schema(description = "Itinerary destiny (Municipality) unique id")
    private Long destinyId;

    @Schema(description = "Itinerary estimated time")
    private Integer estimatedTime;

    @Schema(description = "Itinerary unit time estimated time")
    private UnitTime unitTime;

    @Schema(description = "Itinerary exit time")
    private LocalTime exitTime;

    @Schema(description = "Itinerary arrival time")
    private LocalTime arrivalTime;

    @Schema(description = "Itinerary exit date")
    private LocalDate exitDate;

    @Schema(description = "Itinerary arrival date")
    private LocalDate arrivalDate;
}
