package com.puntopago.ppa.application.usecases.itinerary;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Itinerary;
import com.puntopago.ppa.infrastructure.ports.in.itinerary.UpdateItineraryUseCase;
import com.puntopago.ppa.infrastructure.ports.out.itinerary.ItineraryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateItineraryUseCaseImpl implements UpdateItineraryUseCase {

    private final ItineraryPort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Itinerary execute(Itinerary itinerary) throws ApiException {
        return port.update(itinerary);
    }
}
