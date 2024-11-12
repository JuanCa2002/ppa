package com.puntopago.ppa.infrastructure.ports.out.scale;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Scale;

import java.util.List;

public interface ScalePort {

    List<Scale> saveAll(List<Scale> scales);

    List<Scale> findByItinerary(Long itineraryId);

    void delete(Long scale) throws ApiException;

    boolean hasScale(Long itineraryId);
}
