package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirplaneRequest {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    @Schema(description = "Airplane branch")
    private String branch;

    @NotNull
    @Max(value = Integer.MAX_VALUE)
    @Min(value = 1)
    @Schema(description = "Airplane model")
    private Integer model;

    @NotNull
    @Max(value = Integer.MAX_VALUE)
    @Min(value = 1)
    @Schema(description = "Airplane airline unique id")
    private Integer airlineId;
}
