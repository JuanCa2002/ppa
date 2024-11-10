package com.puntopago.ppa.infrastructure.ports.in.municipality;

import com.puntopago.ppa.domain.filters.MunicipalityFilter;
import com.puntopago.ppa.domain.models.Municipality;

import java.util.List;

public interface FindAllCriteriaMunicipalityUseCase {

    List<Municipality> execute(MunicipalityFilter filter);
}
