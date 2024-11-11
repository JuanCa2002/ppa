package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.itinerary;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItineraryExtendResponse extends ItineraryResponse{

    @Schema(description = "Itinerary origin (Airport) name")
    private String originName;

    @Schema(description = "Itinerary destiny (Airport) name")
    private String destinyName;

    @Schema(description = "Itinerary municipality origin name")
    private String municipalityOriginName;

    @Schema(description = "Itinerary municipality destiny name")
    private String municipalityDestinyName;

    @Schema(description = "Itinerary origin department name")
    private String originDepartmentName;

    @Schema(description = "Itinerary destiny department name")
    private String destinyDepartmentName;
}
