package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane.filters;

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
public class AirplaneRqFilter extends PageableRequest {

    @Size(min = 1, max = 50)
    @Schema(description = "Airplane branch")
    private String branch;

    @Max(value = Integer.MAX_VALUE)
    @Min(value = 1)
    @Schema(description = "Airplane model")
    private Integer model;

    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = ": has to be ACTIVE or INACTIVE")
    @Size(min = 1, max = 9)
    @Schema(description = "Airplane state")
    private String state;

    @NotNull
    @Max(value = Integer.MAX_VALUE)
    @Min(value = 1)
    @Schema(description = "Airplane airline unique id")
    private Integer airlineId;
}
