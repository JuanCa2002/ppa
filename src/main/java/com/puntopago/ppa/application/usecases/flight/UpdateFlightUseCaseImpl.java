package com.puntopago.ppa.application.usecases.flight;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.domain.models.Flight;
import com.puntopago.ppa.infrastructure.ports.in.flight.UpdateFlightUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airplane.AirplanePort;
import com.puntopago.ppa.infrastructure.ports.out.flight.FlightPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateFlightUseCaseImpl implements UpdateFlightUseCase {

    private final FlightPort port;

    private final AirplanePort airplanePort;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Flight execute(Flight flight) throws ApiException {
        Flight foundFlight = port.findById(flight.getId());
        if(flight.getAirplane().getId() != null){
            Airplane airplane = airplanePort.findById(flight.getAirplane().getId());
            foundFlight.setAirplane(airplane);
        }
        if(flight.getPrice() != null ){
            foundFlight.setPrice(flight.getPrice());
        }
        if(flight.getState() != null ){
            foundFlight.setState(flight.getState());
        }
        return port.save(foundFlight);
    }
}
