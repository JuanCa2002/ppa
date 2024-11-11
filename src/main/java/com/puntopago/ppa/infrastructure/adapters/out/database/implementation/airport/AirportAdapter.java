package com.puntopago.ppa.infrastructure.adapters.out.database.implementation.airport;

import com.puntopago.ppa.application.exceptions.airport.AirportNotFoundException;
import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.AirportState;
import com.puntopago.ppa.domain.models.Airport;
import com.puntopago.ppa.domain.records.PageModel;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.AirportEntity;
import com.puntopago.ppa.infrastructure.adapters.out.database.mappers.airport.AirportMapper;
import com.puntopago.ppa.infrastructure.adapters.out.database.repository.AirportRepository;
import com.puntopago.ppa.infrastructure.ports.out.airport.AirportPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AirportAdapter implements AirportPort {

    private final AirportMapper mapper;

    private final AirportRepository repository;

    @Override
    public Airport save(Airport airport) {
        AirportEntity entity = mapper.domainToEntity(airport);
        return mapper.entityToDomain(repository.save(entity));
    }

    @Override
    public Airport findById(Long id) throws ApiException {
        AirportNotFoundException errorNotFound = new AirportNotFoundException();
        errorNotFound.addParams(new Object[]{id});
        return mapper.entityToDomain(repository.findById(id).orElseThrow(() -> errorNotFound));
    }

    @Override
    public Airport update(Airport airport) throws ApiException {
        AirportNotFoundException errorNotFound = new AirportNotFoundException();
        errorNotFound.addParams(new Object[]{airport.getId()});
        AirportEntity target = repository.findById(airport.getId()).orElseThrow(() -> errorNotFound);
        mapper.mergeToEntity(target, airport);
        return mapper.entityToDomain(repository.save(target));
    }

    @Override
    public PageModel<List<Airport>> findByCriteria(String name, Long locationId, Long departmentId, AirportState state, Integer rowsPerPage, Integer skip) {
        int pageNumber = (int) Math.ceil((double)skip/rowsPerPage);
        Pageable pageable = rowsPerPage == 0 ? Pageable.unpaged() : PageRequest.of(pageNumber, rowsPerPage);

        Page<AirportEntity> page = repository.findByCriteria(name != null ? name.toUpperCase(): null, locationId, departmentId, state ,pageable);
        return new PageModel<>(mapper.entitiesToDomains(page.getContent()), BigInteger.valueOf(page.getTotalElements()));
    }
}
