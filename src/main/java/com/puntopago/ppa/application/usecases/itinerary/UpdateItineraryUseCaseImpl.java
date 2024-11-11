package com.puntopago.ppa.application.usecases.itinerary;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Itinerary;
import com.puntopago.ppa.infrastructure.ports.in.itinerary.UpdateItineraryUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airport.AirportPort;
import com.puntopago.ppa.infrastructure.ports.out.itinerary.ItineraryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateItineraryUseCaseImpl implements UpdateItineraryUseCase {

    private final ItineraryPort port;

    private final AirportPort airportPort;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Itinerary execute(Itinerary itinerary) throws ApiException {
        Itinerary previousItinerary = port.findById(itinerary.getId());
        if (itinerary.getOrigin().getId() != null) {
            var originAirport = airportPort.findById(itinerary.getOrigin().getId());
            previousItinerary.setOrigin(originAirport);
        }
        if (itinerary.getDestiny().getId() != null) {
            var destinyAirport = airportPort.findById(itinerary.getDestiny().getId());
            previousItinerary.setDestiny(destinyAirport);
        }
        if (itinerary.getArrivalDate()!= null){
            previousItinerary.setArrivalDate(itinerary.getArrivalDate());
        }
        if (itinerary.getEstimatedTime()!= null){
            previousItinerary.setEstimatedTime(itinerary.getEstimatedTime());
        }
        if (itinerary.getExitDate()!= null){
            previousItinerary.setExitDate(itinerary.getExitDate());
        }
        if (itinerary.getExitTime()!= null){
            previousItinerary.setExitTime(itinerary.getExitTime());
        }

        if (itinerary.getArrivalTime()!= null){
            previousItinerary.setArrivalTime(itinerary.getArrivalTime());
        }
        if (itinerary.getUnitTime()!= null){
            previousItinerary.setUnitTime(itinerary.getUnitTime());
        }
        
        return port.save(previousItinerary);
    }
}
