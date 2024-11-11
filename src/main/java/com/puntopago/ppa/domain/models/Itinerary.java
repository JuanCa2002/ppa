package com.puntopago.ppa.domain.models;

import com.puntopago.ppa.domain.enums.UnitTime;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Itinerary {

    private Long id;

    private Municipality origin;

    private Municipality destiny;

    private Integer estimatedTime;

    private UnitTime unitTime;

    private LocalTime exitTime;

    private LocalTime arrivalTime;

    private LocalDate exitDate;

    private LocalDate arrivalDate;
}
