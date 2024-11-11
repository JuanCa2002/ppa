package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.itinerary;

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
public class ItineraryRequest {

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Itinerary origin (Airport) unique id")
    private Long originId;

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Itinerary destiny (Airport) unique id")
    private Long destinyId;

    @NotNull
    @Min(value = 1)
    @Max(value = 999L)
    @Schema(description = "Itinerary estimated time")
    private Integer estimatedTime;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 8)
    @Pattern(regexp = "^(HOURS|MINUTES)$", message = ": has to be HOURS or MINUTES")
    @Schema(description = "Itinerary unit time estimated time")
    private String unitTime;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 8)
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message = ": must be in HH:mm:ss format")
    @Schema(description = "Itinerary exit time")
    private String exitTime;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 8)
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message = ": must be in HH:mm:ss format")
    @Schema(description = "Itinerary arrival time")
    private String arrivalTime;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 10)
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = ": must be in yyyy-MM-dd format")
    @Schema(description = "Itinerary exit date")
    private String exitDate;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 10)
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = ": must be in yyyy-MM-dd format")
    @Schema(description = "Itinerary arrival date")
    private String arrivalDate;
}
