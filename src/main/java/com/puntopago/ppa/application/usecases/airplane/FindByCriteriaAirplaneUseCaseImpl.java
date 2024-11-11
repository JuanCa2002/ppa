package com.puntopago.ppa.application.usecases.airplane;

import com.puntopago.ppa.domain.filters.AirplaneFilter;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.domain.records.PageModel;
import com.puntopago.ppa.infrastructure.ports.in.airplane.FindByCriteriaAirplaneUseCase;
import com.puntopago.ppa.infrastructure.ports.out.airplane.AirplanePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindByCriteriaAirplaneUseCaseImpl implements FindByCriteriaAirplaneUseCase {

    private final AirplanePort port;

    @Transactional(readOnly = true)
    @Override
    public PageModel<List<Airplane>> execute(AirplaneFilter filter) {
        return port.findByCriteria(filter.getBranch(), filter.getModel(), filter.getState(), filter.getAirlineId(),
                filter.getRowsPerPage(), filter.getSkip());
    }
}
