package com.puntopago.ppa.infrastructure.ports.in.airline;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Airline;

public interface FindByIdAirlineUseCase {

    Airline execute(Long id) throws ApiException;
}
