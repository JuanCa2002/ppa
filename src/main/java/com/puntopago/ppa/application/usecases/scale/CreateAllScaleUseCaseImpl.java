package com.puntopago.ppa.application.usecases.scale;
import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Scale;
import com.puntopago.ppa.infrastructure.ports.in.scale.CreateAllScaleUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airport.AirportPort;
import com.puntopago.ppa.infrastructure.ports.out.itinerary.ItineraryPort;
import com.puntopago.ppa.infrastructure.ports.out.scale.ScalePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateAllScaleUseCaseImpl implements CreateAllScaleUseCase {

    private final ScalePort port;

    private final ItineraryPort itineraryPort;

    private final AirportPort airportPort;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Scale> createAll(List<Scale> scales) throws ApiException {
        for(Scale scale: scales){
            itineraryPort.findById(scale.getItinerary().getId());
            airportPort.findById(scale.getScalePlace().getId());
        }
        return port.saveAll(scales);
    }
}
