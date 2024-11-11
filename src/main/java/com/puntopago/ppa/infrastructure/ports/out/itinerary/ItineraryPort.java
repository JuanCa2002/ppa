package com.puntopago.ppa.infrastructure.ports.out.itinerary;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Itinerary;

public interface ItineraryPort {

    Itinerary save(Itinerary itinerary);

    Itinerary update(Itinerary itinerary) throws ApiException;

    Itinerary findById(Long id) throws ApiException;
}
