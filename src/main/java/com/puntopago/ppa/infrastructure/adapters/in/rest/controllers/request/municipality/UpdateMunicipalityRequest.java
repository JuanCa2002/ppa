package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.municipality;

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
public class UpdateMunicipalityRequest {

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Municipality unique id")
    private Long id;

    @Size(min = 1, max = 50)
    @Schema(description = "Municipality name")
    @Pattern(regexp = "^[A-Z\s]+$", message = ": should only contain capital letters and spaces.")
    private String name;

    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = ": has to be ACTIVE or INACTIVE")
    @Size(min = 1, max = 9)
    @Schema(description = "Municipality state")
    private String state;
}
