package com.puntopago.ppa.application.usecases.airport;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Airport;
import com.puntopago.ppa.infrastructure.ports.in.airport.FindByIdAirportUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airport.AirportPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindByIdAirportUseCaseImpl implements FindByIdAirportUseCase {

    private final AirportPort port;

    @Transactional(readOnly = true)
    @Override
    public Airport execute(Long id) throws ApiException {
        return port.findById(id);
    }
}
