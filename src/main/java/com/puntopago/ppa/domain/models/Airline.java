package com.puntopago.ppa.domain.models;

import com.puntopago.ppa.domain.enums.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Airline {
    private Long id;

    private String name;

    private State state;
}
