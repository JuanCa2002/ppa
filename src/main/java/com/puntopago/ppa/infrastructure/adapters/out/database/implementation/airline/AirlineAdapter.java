package com.puntopago.ppa.infrastructure.adapters.out.database.implementation.airline;

import com.puntopago.ppa.application.exceptions.airline.AirlineNotFoundException;
import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Airline;
import com.puntopago.ppa.domain.records.PageModel;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.AirlineEntity;
import com.puntopago.ppa.infrastructure.adapters.out.database.mappers.airline.AirlineMapper;
import com.puntopago.ppa.infrastructure.adapters.out.database.repository.AirlineRepository;
import com.puntopago.ppa.infrastructure.ports.out.airline.AirlinePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AirlineAdapter implements AirlinePort {

    private final AirlineMapper mapper;

    private final AirlineRepository repository;

    @Override
    public Airline save(Airline airline) {
        AirlineEntity entity = mapper.domainToEntity(airline);
        return mapper.entityToDomain(repository.save(entity));
    }

    @Override
    public Airline update(Airline airline) throws ApiException {
        AirlineNotFoundException errorNotFound = new AirlineNotFoundException();
        errorNotFound.addParams(new Object[]{airline.getId()});
        AirlineEntity target = repository.findById(airline.getId()).orElseThrow(() -> errorNotFound);
        mapper.mergeToEntity(target, airline);
        return mapper.entityToDomain(repository.save(target));
    }

    @Override
    public Airline findById(Long id) throws ApiException {
        AirlineNotFoundException errorNotFound = new AirlineNotFoundException();
        errorNotFound.addParams(new Object[]{id});
        return mapper.entityToDomain(repository.findById(id).orElseThrow(() -> errorNotFound));
    }

    @Override
    public PageModel<List<Airline>> findByCriteria(String name, State state, Integer rowsPerPage, Integer skip) {
        int pageNumber = (int) Math.ceil((double)skip/rowsPerPage);
        Pageable pageable = rowsPerPage == 0 ? Pageable.unpaged() : PageRequest.of(pageNumber, rowsPerPage);

        Page<AirlineEntity> page = repository.findByCriteria(name, state, pageable);
        return new PageModel<>(mapper.entitiesToDomains(page.getContent()), BigInteger.valueOf(page.getTotalElements()));
    }
}
