package com.puntopago.ppa.domain.models;

import com.puntopago.ppa.domain.enums.UnitTime;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class Scale {

    private Long id;

    private Airport scalePlace;

    private LocalTime arrivalTimeScale;

    private Integer estimatedTimeScale;

    private UnitTime unitTime;

    private Itinerary itinerary;
}
