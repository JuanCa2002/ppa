package com.puntopago.ppa.domain.filters;

import com.puntopago.ppa.domain.enums.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirplaneFilter {

    private String branch;

    private Integer model;

    private State state;

    private Integer airlineId;

    private Integer rowsPerPage;

    private Integer skip;
}
