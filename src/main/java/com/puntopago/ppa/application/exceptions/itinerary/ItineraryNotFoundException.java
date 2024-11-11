package com.puntopago.ppa.application.exceptions.itinerary;

import com.puntopago.ppa.application.exceptions.general.NotFoundException;

public class ItineraryNotFoundException extends NotFoundException {

    public ItineraryNotFoundException() {
        super(ItineraryApiErrorMessages.ITINERARY_NOT_FOUND);
    }
}
