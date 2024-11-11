package com.puntopago.ppa.infrastructure.ports.out.itinerary;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Itinerary;

public interface ItineraryPort {

    Itinerary save(Itinerary itinerary);

    Itinerary findById(Long id) throws ApiException;

    Itinerary findByFlight(Long flightId) throws ApiException;
}
