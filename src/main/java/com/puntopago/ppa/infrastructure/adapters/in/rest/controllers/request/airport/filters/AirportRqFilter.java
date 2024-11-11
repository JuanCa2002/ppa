package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport.filters;

import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.PageableRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportRqFilter extends PageableRequest {

    @Size(min = 1, max = 80)
    @Pattern(regexp = "^[A-Z\s]+$", message = ": should only contain capital letters and spaces.")
    @Schema(description = "Airport name")
    private String name;

    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Airport location (Municipality) unique id")
    private Long locationId;

    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Airport department unique id")
    private Long departmentId;

    @Pattern(regexp = "^(OUT_OF_SERVICE|ALLOWED|BUSY)$", message = ": has to be OUT_OF_SERVICE, ALLOWED or BUSY")
    @Size(min = 1, max = 15)
    @Schema(description = "Airport state", defaultValue = "ALLOWED")
    private String state;
}
