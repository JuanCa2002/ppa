package com.puntopago.ppa.infrastructure.ports.out.flight;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.filters.FlightFilter;
import com.puntopago.ppa.domain.models.Flight;
import com.puntopago.ppa.domain.records.PageModel;

import java.util.List;

public interface FlightPort {

    Flight save(Flight flight);

    Flight findById(Long id) throws ApiException;

    PageModel<List<Flight>> findByCriteria(FlightFilter filter);
}
