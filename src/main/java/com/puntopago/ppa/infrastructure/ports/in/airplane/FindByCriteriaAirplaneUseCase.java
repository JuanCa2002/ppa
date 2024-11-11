package com.puntopago.ppa.infrastructure.ports.in.airplane;

import com.puntopago.ppa.domain.filters.AirplaneFilter;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.domain.records.PageModel;

import java.util.List;

public interface FindByCriteriaAirplaneUseCase {

    PageModel<List<Airplane>> execute(AirplaneFilter filter);
}
