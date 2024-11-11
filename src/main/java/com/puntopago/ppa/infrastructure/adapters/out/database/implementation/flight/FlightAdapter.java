package com.puntopago.ppa.infrastructure.adapters.out.database.implementation.flight;

import com.puntopago.ppa.application.exceptions.flight.FlightNotFoundException;
import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.filters.FlightFilter;
import com.puntopago.ppa.domain.models.Flight;
import com.puntopago.ppa.domain.records.PageModel;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.FlightEntity;
import com.puntopago.ppa.infrastructure.adapters.out.database.mappers.flight.FlightMapper;
import com.puntopago.ppa.infrastructure.adapters.out.database.repository.FlightRepository;
import com.puntopago.ppa.infrastructure.ports.out.flight.FlightPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FlightAdapter implements FlightPort {

    private final FlightRepository repository;

    private final FlightMapper mapper;
    @Override
    public Flight save(Flight flight) {
        FlightEntity entity = mapper.domainToEntity(flight);
        return mapper.entityToDomain(repository.save(entity));
    }

    @Override
    public Flight findById(Long id) throws ApiException {
        FlightNotFoundException errorNotFound = new FlightNotFoundException();
        errorNotFound.addParams(new Object[]{id});
        return mapper.entityToDomain(repository.findById(id).orElseThrow(() -> errorNotFound));
    }

    @Override
    public PageModel<List<Flight>> findByCriteria(FlightFilter filter) {
        int pageNumber = (int) Math.ceil((double)filter.getSkip()/filter.getRowsPerPage());
        Pageable pageable = filter.getRowsPerPage() == 0 ? Pageable.unpaged() : PageRequest.of(pageNumber, filter.getRowsPerPage());

        Page<FlightEntity> page = repository.findByCriteria(filter, filter.getState() ,pageable);
        return new PageModel<>(mapper.entitiesToDomains(page.getContent()), BigInteger.valueOf(page.getTotalElements()));
    }
}
