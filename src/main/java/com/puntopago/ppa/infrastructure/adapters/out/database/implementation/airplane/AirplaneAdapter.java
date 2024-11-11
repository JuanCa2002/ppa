package com.puntopago.ppa.infrastructure.adapters.out.database.implementation.airplane;

import com.puntopago.ppa.application.exceptions.airplane.AirplaneNotFoundException;
import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.domain.records.PageModel;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.AirplaneEntity;
import com.puntopago.ppa.infrastructure.adapters.out.database.mappers.airplane.AirplaneMapper;
import com.puntopago.ppa.infrastructure.adapters.out.database.repository.AirplaneRepository;
import com.puntopago.ppa.infrastructure.ports.out.airplane.AirplanePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AirplaneAdapter implements AirplanePort {

    private final AirplaneMapper mapper;

    private final AirplaneRepository repository;

    @Override
    public Airplane save(Airplane airplane) {
        AirplaneEntity entity = mapper.domainToEntity(airplane);
        return mapper.entityToDomain(repository.save(entity));
    }

    @Override
    public Airplane update(Airplane airplane) throws ApiException {
        AirplaneNotFoundException errorNotFound = new AirplaneNotFoundException();
        errorNotFound.addParams(new Object[]{airplane.getId()});
        AirplaneEntity target = repository.findById(airplane.getId()).orElseThrow(() -> errorNotFound);
        mapper.mergeToEntity(target, airplane);
        return mapper.entityToDomain(repository.save(target));
    }

    @Override
    public Airplane findById(Long id) throws ApiException {
        AirplaneNotFoundException errorNotFound = new AirplaneNotFoundException();
        errorNotFound.addParams(new Object[]{id});
        return mapper.entityToDomain(repository.findById(id).orElseThrow(() -> errorNotFound));
    }

    @Override
    public PageModel<List<Airplane>> findByCriteria(String branch, Integer model, State state, Integer airlineId, Integer rowsPerPage, Integer skip) {
        int pageNumber = (int) Math.ceil((double)skip/rowsPerPage);
        Pageable pageable = rowsPerPage == 0 ? Pageable.unpaged() : PageRequest.of(pageNumber, rowsPerPage);

        Page<AirplaneEntity> page = repository.findByCriteria(branch, model, state, airlineId,pageable);
        return new PageModel<>(mapper.entitiesToDomains(page.getContent()), BigInteger.valueOf(page.getTotalElements()));
    }
}
