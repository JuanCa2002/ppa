package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department.filters;

import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.PageableRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRqFilter extends PageableRequest {

    @Size(min = 1, max = 50)
    @Schema(description = "Department name")
    private String name;

    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = ": has to be ACTIVE or INACTIVE")
    @Size(min = 1, max = 9)
    @Schema(description = "Department state")
    private String state;
}
