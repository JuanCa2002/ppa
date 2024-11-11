package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.airport;

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
public class AirportRequest {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 80)
    @Pattern(regexp = "^[A-Z\s]+$", message = ": should only contain capital letters and spaces.")
    @Schema(description = "Airport name")
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 20)
    @Schema(description = "Airport address")
    private String address;

    @NotNull
    @Min(value = 1)
    @Max(value = 999999999999999999L)
    @Schema(description = "Airport location (Municipality) unique id")
    private Long locationId;
}
