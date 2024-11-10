package com.puntopago.ppa.infrastructure.adapters.out.database.implementation.municipality;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.application.exceptions.municipality.MunicipalityNotFoundException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Municipality;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.MunicipalityEntity;
import com.puntopago.ppa.infrastructure.adapters.out.database.mappers.municipality.MunicipalityMapper;
import com.puntopago.ppa.infrastructure.adapters.out.database.repository.MunicipalityRepository;
import com.puntopago.ppa.infrastructure.ports.out.municipality.MunicipalityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MunicipalityAdapter implements MunicipalityPort {

    private final MunicipalityMapper mapper;

    private final MunicipalityRepository repository;

    @Override
    public Municipality save(Municipality municipality) {
        MunicipalityEntity entity = mapper.domainToEntity(municipality);
        return mapper.entityToDomain(repository.save(entity));
    }

    @Override
    public Municipality update(Municipality municipality) throws ApiException {
        MunicipalityNotFoundException errorNotFound = new MunicipalityNotFoundException();
        errorNotFound.addParams(new Object[]{municipality.getId()});
        MunicipalityEntity target = repository.findById(municipality.getId()).orElseThrow(() -> errorNotFound);
        mapper.mergeToEntity(target, municipality);
        return mapper.entityToDomain(repository.save(target));
    }

    @Override
    public Municipality findById(Long id) throws ApiException {
        MunicipalityNotFoundException errorNotFound = new MunicipalityNotFoundException();
        errorNotFound.addParams(new Object[]{id});
        return mapper.entityToDomain(repository.findById(id).orElseThrow(() -> errorNotFound));
    }

    @Override
    public List<Municipality> findAllByCriteria(Long departmentId, State state, String name) {
        return mapper.entitiesToDomains(repository.findAllByCriteria(departmentId, name!= null ? name.toUpperCase(): null, state));
    }
}
