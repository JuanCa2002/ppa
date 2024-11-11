package com.puntopago.ppa.application.usecases.airport;

import com.puntopago.ppa.domain.filters.AirportFilter;
import com.puntopago.ppa.domain.models.Airport;
import com.puntopago.ppa.domain.records.PageModel;
import com.puntopago.ppa.infrastructure.ports.in.airport.FindByCriteriaAirportUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airport.AirportPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindByCriteriaAirportUseCaseImpl implements FindByCriteriaAirportUseCase {

    private final AirportPort port;

    @Transactional(readOnly = true)
    @Override
    public PageModel<List<Airport>> execute(AirportFilter filter) {
        return port.findByCriteria(filter.getName(), filter.getLocationId(), filter.getDepartmentId(), filter.getState(),
                filter.getRowsPerPage(), filter.getSkip());
    }
}
