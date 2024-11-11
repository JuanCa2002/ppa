package com.puntopago.ppa.domain.filters;

import com.puntopago.ppa.domain.enums.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirlineFilter {
    private String name;

    private State state;

    private Integer rowsPerPage;

    private Integer skip;

}
