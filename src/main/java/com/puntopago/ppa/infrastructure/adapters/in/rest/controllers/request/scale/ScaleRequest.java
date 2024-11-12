package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.scale;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScaleRequest {

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Scale place (Airport) unique id")
    private Long scalePlaceId;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 8)
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message = ": must be in HH:mm:ss format")
    @Schema(description = "Scale arrival time")
    private String arrivalTimeScale;

    @NotNull
    @Min(value = 1)
    @Max(value = 999L)
    @Schema(description = "Scale estimated time")
    private Integer estimatedTimeScale;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 8)
    @Pattern(regexp = "^(HOURS|MINUTES)$", message = ": has to be HOURS or MINUTES")
    @Schema(description = "Scale unit time estimated time")
    private String unitTime;

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Scale itinerary unique id")
    private Long itineraryId;
}
