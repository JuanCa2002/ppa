package com.puntopago.ppa.infrastructure.ports.in.airline;

import com.puntopago.ppa.domain.models.Airline;

public interface CreateAirlineUseCase {

    Airline execute(Airline airline);
}
