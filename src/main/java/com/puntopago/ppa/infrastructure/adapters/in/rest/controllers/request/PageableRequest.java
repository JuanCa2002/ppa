package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableRequest {

    @NotNull
    @Max(value = Integer.MAX_VALUE)
    @Min(value = 0)
    @Schema(description = "Quantity of rows per page", defaultValue = "10")
    private Integer rowsPerPage;

    @NotNull
    @Max(value = Integer.MAX_VALUE)
    @Min(value = 0)
    @Schema(description = "Quantity of rows to skip", defaultValue = "0")
    private Integer skip;
}
