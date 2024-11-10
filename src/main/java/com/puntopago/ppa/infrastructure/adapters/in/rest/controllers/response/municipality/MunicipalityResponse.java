package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.municipality;

import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.department.DepartmentResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MunicipalityResponse {

    @Schema(description = "Municipality unique id")
    private Long id;

    @Schema(description = "Municipality name")
    private String name;

    @Schema(description = "Municipality state")
    private State state;

    @Schema(description = "Municipality department")
    private DepartmentResponse department;

}
