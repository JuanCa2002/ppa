package com.puntopago.ppa.application.usecases.airplane;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Airline;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.infrastructure.ports.in.airplane.CreateAirplaneUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airline.AirlinePort;
import com.puntopago.ppa.infrastructure.ports.out.airplane.AirplanePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateAirplaneUseCaseImpl implements CreateAirplaneUseCase {

    private final AirplanePort port;

    private final AirlinePort airlinePort;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Airplane execute(Airplane airplane) throws ApiException {
        Airline foundAirline = airlinePort.findById(airplane.getAirline().getId());
        airplane.setId(null);
        airplane.setState(State.ACTIVE);
        Airplane savedAirplane = port.save(airplane);
        savedAirplane.setAirline(foundAirline);
        return savedAirplane;
    }
}
