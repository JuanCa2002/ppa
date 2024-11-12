package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.scale;

import com.puntopago.ppa.domain.enums.UnitTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class ScaleResponse {

    @Schema(description = "Scale unique id")
    private Long id;

    @Schema(description = "Scale place (Airport) unique id")
    private Long scalePlaceId;

    @Schema(description = "Scale arrival time")
    private LocalTime arrivalTimeScale;

    @Schema(description = "Scale estimated time")
    private Integer estimatedTimeScale;

    @Schema(description = "Scale unit time estimated time")
    private UnitTime unitTime;

    @Schema(description = "Scale itinerary unique id")
    private Long itineraryId;

    @Schema(description = "Scale Airport Name")
    private String scalePlaceName;

    @Schema(description = "Scale Airport location Name")
    private String scalePlaceLocationName;
}
