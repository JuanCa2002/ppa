package com.puntopago.ppa.application.usecases.itinerary;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Itinerary;
import com.puntopago.ppa.infrastructure.ports.in.itinerary.CreateItineraryUseCase;
import com.puntopago.ppa.infrastructure.ports.out.itinerary.ItineraryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateItineraryUseCaseImpl implements CreateItineraryUseCase {

    private final ItineraryPort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Itinerary execute(Itinerary itinerary) throws ApiException {
        return port.save(itinerary);
    }
}
