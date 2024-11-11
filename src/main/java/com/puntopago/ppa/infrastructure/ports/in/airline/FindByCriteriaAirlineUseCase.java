package com.puntopago.ppa.infrastructure.ports.in.airline;

import com.puntopago.ppa.domain.filters.AirlineFilter;
import com.puntopago.ppa.domain.models.Airline;
import com.puntopago.ppa.domain.records.PageModel;

import java.util.List;

public interface FindByCriteriaAirlineUseCase {

    PageModel<List<Airline>> execute(AirlineFilter filter);
}
