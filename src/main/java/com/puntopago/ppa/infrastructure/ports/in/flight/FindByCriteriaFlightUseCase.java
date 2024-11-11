package com.puntopago.ppa.infrastructure.ports.in.flight;

import com.puntopago.ppa.domain.filters.FlightFilter;
import com.puntopago.ppa.domain.models.Flight;
import com.puntopago.ppa.domain.records.PageModel;

import java.util.List;

public interface FindByCriteriaFlightUseCase {

    PageModel<List<Flight>> execute(FlightFilter filter);
}
