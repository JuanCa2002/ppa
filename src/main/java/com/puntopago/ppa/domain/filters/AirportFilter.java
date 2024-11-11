package com.puntopago.ppa.domain.filters;

import com.puntopago.ppa.domain.enums.AirportState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportFilter {

    private String name;

    private Long locationId;

    private Long departmentId;

    private AirportState state;

    private Integer rowsPerPage;

    private Integer skip;

}
