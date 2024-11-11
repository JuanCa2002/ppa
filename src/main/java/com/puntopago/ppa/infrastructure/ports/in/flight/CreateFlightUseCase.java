package com.puntopago.ppa.infrastructure.ports.in.flight;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Flight;

public interface CreateFlightUseCase {

    Flight execute(Flight flight) throws ApiException;
}
