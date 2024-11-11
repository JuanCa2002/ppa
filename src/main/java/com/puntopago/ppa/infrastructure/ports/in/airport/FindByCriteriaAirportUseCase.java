package com.puntopago.ppa.infrastructure.ports.in.airport;

import com.puntopago.ppa.domain.filters.AirportFilter;
import com.puntopago.ppa.domain.models.Airport;
import com.puntopago.ppa.domain.records.PageModel;

import java.util.List;

public interface FindByCriteriaAirportUseCase {

    PageModel<List<Airport>> execute(AirportFilter filter);
}
