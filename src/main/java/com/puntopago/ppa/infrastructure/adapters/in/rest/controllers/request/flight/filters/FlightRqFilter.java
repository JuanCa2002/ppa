package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight.filters;

import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.PageableRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightRqFilter extends PageableRequest {

    @Min(value = 1)
    @Schema(description = "Flight price")
    private Double price;

    @Size(min = 1, max = 20)
    @Pattern(
            regexp = "^(SCHEDULED|BOARDING|AT_GATE|DELAYED|CANCELLED|POSTPONED|IN_FLIGHT|DIVERTED|LANDED|AT_GATE_ARRIVAL|ON_HOLD|DEPARTED|RETURN_TO_GATE|FINAL_CALL|ARRIVED|UNKNOWN)$",
            message = ": must be one of the following values - SCHEDULED, BOARDING, AT_GATE, DELAYED, CANCELLED, POSTPONED, IN_FLIGHT, DIVERTED, LANDED, AT_GATE_ARRIVAL, ON_HOLD, DEPARTED, RETURN_TO_GATE, FINAL_CALL, ARRIVED, UNKNOWN"
    )
    private String state;

    @Size(min = 1, max = 10)
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = ": must be in yyyy-MM-dd format")
    @Schema(description = "Flight exit date")
    private String exitDate;

    @Size(min = 1, max = 8)
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message = ": must be in HH:mm:ss format")
    @Schema(description = "Flight exit time")
    private String exitTime;

    @Min(value = 1)
    @Max(value = 999L)
    @Schema(description = "Flight estimated time")
    private Integer estimatedTime;

    @Size(min = 1, max = 8)
    @Pattern(regexp = "^(HOURS|MINUTES)$", message = ": has to be HOURS or MINUTES")
    @Schema(description = "Itinerary unit time estimated time")
    private String unitTime;

    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Flight airline unique id")
    private Long airlineId;

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Flight origin (Municipality) unique id")
    private Long originId;

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Flight destiny (Municipality) unique id")
    private Long destinyId;

    @Schema(description = "Flight flag to know if is direct or with scale")
    private Boolean isDirect;
}
