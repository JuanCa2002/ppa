package com.puntopago.ppa.domain.models;

import com.puntopago.ppa.domain.enums.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Airplane {

    private Long id;

    private String branch;

    private Integer model;

    private State state;

    private Airline airline;
}
