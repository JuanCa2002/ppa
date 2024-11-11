package com.puntopago.ppa.domain.filters;

import com.puntopago.ppa.domain.enums.FlightState;
import com.puntopago.ppa.domain.enums.UnitTime;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class FlightFilter {

    private Double price;

    private FlightState state;

    private LocalDate exitDate;

    private LocalTime exitTime;

    private Integer estimatedTime;

    private UnitTime unitTime;

    private Long airlineId;

    private Long originId;

    private Long destinyId;

    private Integer rowsPerPage;

    private Integer skip;

}
