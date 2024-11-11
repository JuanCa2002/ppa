package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.flight;

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
public class UpdateFlightRequest {
    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Flight unique id")
    private Long id;

    @Min(value = 1)
    @Schema(description = "Flight price")
    private Double price;

    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Flight airplane unique id")
    private Long airplaneId;

    @Size(min = 1, max = 20)
    @Pattern(
            regexp = "^(SCHEDULED|BOARDING|AT_GATE|DELAYED|CANCELLED|POSTPONED|IN_FLIGHT|DIVERTED|LANDED|AT_GATE_ARRIVAL|ON_HOLD|DEPARTED|RETURN_TO_GATE|FINAL_CALL|ARRIVED|UNKNOWN)$",
            message = ": must be one of the following values - SCHEDULED, BOARDING, AT_GATE, DELAYED, CANCELLED, POSTPONED, IN_FLIGHT, DIVERTED, LANDED, AT_GATE_ARRIVAL, ON_HOLD, DEPARTED, RETURN_TO_GATE, FINAL_CALL, ARRIVED, UNKNOWN"
    )
    @Schema(description = "Flight state")
    private String state;
}
