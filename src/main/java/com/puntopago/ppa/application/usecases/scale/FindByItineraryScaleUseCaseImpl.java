package com.puntopago.ppa.application.usecases.scale;

import com.puntopago.ppa.domain.models.Scale;
import com.puntopago.ppa.infrastructure.ports.in.scale.FindByItineraryScaleUseCase;
import com.puntopago.ppa.infrastructure.ports.out.scale.ScalePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindByItineraryScaleUseCaseImpl implements FindByItineraryScaleUseCase {

    private final ScalePort port;

    @Transactional(readOnly = true)
    @Override
    public List<Scale> execute(Long itineraryId) {
        return port.findByItinerary(itineraryId);
    }
}
