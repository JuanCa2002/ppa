package com.puntopago.ppa.domain.models;

import com.puntopago.ppa.domain.enums.FlightState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flight {

    private Long id;

    private Double price;

    private Airplane airplane;

    private Itinerary itinerary;

    private FlightState state;

    private Boolean isDirect;
}
