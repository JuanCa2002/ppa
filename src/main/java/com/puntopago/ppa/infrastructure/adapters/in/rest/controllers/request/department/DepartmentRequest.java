package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRequest {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    @Schema(description = "Department name")
    private String name;
}
