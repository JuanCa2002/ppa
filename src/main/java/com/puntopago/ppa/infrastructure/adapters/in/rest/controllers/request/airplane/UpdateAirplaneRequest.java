package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airplane;

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
public class UpdateAirplaneRequest extends AirplaneRequest {

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Airplane unique id")
    private Long id;

    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = ": has to be ACTIVE or INACTIVE")
    @Size(min = 1, max = 9)
    @Schema(description = "Airplane state")
    private String state;

}
