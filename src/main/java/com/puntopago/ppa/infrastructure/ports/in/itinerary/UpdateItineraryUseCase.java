package com.puntopago.ppa.infrastructure.ports.in.itinerary;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Itinerary;

public interface UpdateItineraryUseCase {

    Itinerary execute(Itinerary itinerary) throws ApiException;
}
