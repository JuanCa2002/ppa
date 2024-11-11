package com.puntopago.ppa.application.usecases.flight;

import com.puntopago.ppa.domain.filters.FlightFilter;
import com.puntopago.ppa.domain.models.Flight;
import com.puntopago.ppa.domain.records.PageModel;
import com.puntopago.ppa.infrastructure.ports.in.flight.FindByCriteriaFlightUseCase;
import com.puntopago.ppa.infrastructure.ports.out.flight.FlightPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindByCriteriaFlightUseCaseImpl implements FindByCriteriaFlightUseCase {

    private final FlightPort port;

    @Transactional(readOnly = true)
    @Override
    public PageModel<List<Flight>> execute(FlightFilter filter) {
        return port.findByCriteria(filter);
    }
}
