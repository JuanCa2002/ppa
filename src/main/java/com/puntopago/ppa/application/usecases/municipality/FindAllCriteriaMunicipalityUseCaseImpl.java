package com.puntopago.ppa.application.usecases.municipality;

import com.puntopago.ppa.domain.filters.MunicipalityFilter;
import com.puntopago.ppa.domain.models.Municipality;
import com.puntopago.ppa.infrastructure.ports.in.municipality.FindAllCriteriaMunicipalityUseCase;
import com.puntopago.ppa.infrastructure.ports.out.municipality.MunicipalityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllCriteriaMunicipalityUseCaseImpl implements FindAllCriteriaMunicipalityUseCase {

    private final MunicipalityPort port;

    @Transactional(readOnly = true)
    @Override
    public List<Municipality> execute(MunicipalityFilter filter) {
        return port.findAllByCriteria(filter.getDepartmentId(), filter.getState(), filter.getName());
    }
}
