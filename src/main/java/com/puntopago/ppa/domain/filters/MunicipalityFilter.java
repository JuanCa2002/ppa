package com.puntopago.ppa.domain.filters;

import com.puntopago.ppa.domain.enums.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MunicipalityFilter {

    private String name;

    private State state;

    private Long departmentId;
}
