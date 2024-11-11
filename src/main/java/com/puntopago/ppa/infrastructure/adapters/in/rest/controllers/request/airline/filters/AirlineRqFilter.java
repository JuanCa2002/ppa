package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airline.filters;

import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.PageableRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirlineRqFilter extends PageableRequest {

    @Size(min = 1, max = 50)
    @Schema(description = "Airline name")
    private String name;

    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = ": has to be ACTIVE or INACTIVE")
    @Size(min = 1, max = 9)
    @Schema(description = "Airline state")
    private String state;
}
