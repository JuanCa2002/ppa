package com.puntopago.ppa.application.exceptions.itinerary;

import com.puntopago.ppa.application.exceptions.general.NotFoundException;

public class ItineraryByFlightNotFoundException extends NotFoundException {

    public ItineraryByFlightNotFoundException() {
        super(ItineraryApiErrorMessages.ITINERARY_BY_FLIGHT_NOT_FOUND);
    }
}
