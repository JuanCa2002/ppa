package com.puntopago.ppa.application.usecases.airline;

import com.puntopago.ppa.domain.filters.AirlineFilter;
import com.puntopago.ppa.domain.models.Airline;
import com.puntopago.ppa.domain.records.PageModel;
import com.puntopago.ppa.infrastructure.ports.in.airline.FindByCriteriaAirlineUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airline.AirlinePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindByCriteriaAirlineUseCaseImpl implements FindByCriteriaAirlineUseCase {

    private final AirlinePort port;

    @Transactional(readOnly = true)
    @Override
    public PageModel<List<Airline>> execute(AirlineFilter filter) {
        return port.findByCriteria(filter.getName(), filter.getState(), filter.getRowsPerPage(), filter.getSkip());
    }
}
