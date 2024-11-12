package com.puntopago.ppa.application.usecases.flight;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.FlightState;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.domain.models.Flight;
import com.puntopago.ppa.domain.models.Itinerary;
import com.puntopago.ppa.infrastructure.ports.in.flight.CreateFlightUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airplane.AirplanePort;
import com.puntopago.ppa.infrastructure.ports.out.flight.FlightPort;
import com.puntopago.ppa.infrastructure.ports.out.itinerary.ItineraryPort;
import com.puntopago.ppa.infrastructure.ports.out.scale.ScalePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateFlightUseCaseImpl implements CreateFlightUseCase {

    private final FlightPort port;

    private final ItineraryPort itineraryPort;

    private final AirplanePort airplanePort;

    private final ScalePort scalePort;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Flight execute(Flight flight) throws ApiException {
        Itinerary foundItinerary = itineraryPort.findById(flight.getItinerary().getId());
        Airplane foundAirplane = airplanePort.findById(flight.getAirplane().getId());
        flight.setState(FlightState.SCHEDULED);
        flight.setIsDirect(!scalePort.hasScale(foundItinerary.getId()));
        Flight savedFlight = port.save(flight);
        savedFlight.setAirplane(foundAirplane);
        savedFlight.setItinerary(foundItinerary);
        return savedFlight;
    }
}
