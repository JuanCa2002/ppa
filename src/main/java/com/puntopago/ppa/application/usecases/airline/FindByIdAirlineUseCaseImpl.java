package com.puntopago.ppa.application.usecases.airline;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Airline;
import com.puntopago.ppa.infrastructure.ports.in.airline.FindByIdAirlineUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airline.AirlinePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindByIdAirlineUseCaseImpl implements FindByIdAirlineUseCase {

    private final AirlinePort port;

    @Transactional(readOnly = true)
    @Override
    public Airline execute(Long id) throws ApiException {
        return port.findById(id);
    }

}
