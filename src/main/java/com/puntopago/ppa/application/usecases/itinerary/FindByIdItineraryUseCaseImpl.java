package com.puntopago.ppa.application.usecases.itinerary;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Itinerary;
import com.puntopago.ppa.infrastructure.ports.in.itinerary.FindByIdItineraryUseCase;
import com.puntopago.ppa.infrastructure.ports.out.itinerary.ItineraryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindByIdItineraryUseCaseImpl implements FindByIdItineraryUseCase {

    private final ItineraryPort port;

    @Transactional(readOnly = true)
    @Override
    public Itinerary execute(Long id) throws ApiException {
        return port.findById(id);
    }
}
