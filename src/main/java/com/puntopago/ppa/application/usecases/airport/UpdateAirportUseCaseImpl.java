package com.puntopago.ppa.application.usecases.airport;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Airport;
import com.puntopago.ppa.infrastructure.ports.in.airport.UpdateAirportUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airport.AirportPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateAirportUseCaseImpl implements UpdateAirportUseCase {

    private final AirportPort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Airport execute(Airport airport) throws ApiException {
        return port.update(airport);
    }
}
