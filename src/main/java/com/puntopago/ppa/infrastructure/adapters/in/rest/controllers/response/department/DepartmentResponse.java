package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.department;

import com.puntopago.ppa.domain.enums.State;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentResponse {

    @Schema(description = "Department unique id")
    private Long id;

    @Schema(description = "Department name")
    private String name;

    @Schema(description = "Department state")
    private State state;
}
