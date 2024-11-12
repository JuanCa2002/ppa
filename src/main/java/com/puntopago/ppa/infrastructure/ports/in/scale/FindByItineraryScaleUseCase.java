package com.puntopago.ppa.infrastructure.ports.in.scale;

import com.puntopago.ppa.domain.models.Scale;

import java.util.List;

public interface FindByItineraryScaleUseCase {

    List<Scale> execute(Long itineraryId);
}
