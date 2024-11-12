package com.puntopago.ppa.infrastructure.adapters.out.database.implementation.scale;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.application.exceptions.scale.ScaleNotFoundException;
import com.puntopago.ppa.domain.models.Scale;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.ScaleEntity;
import com.puntopago.ppa.infrastructure.adapters.out.database.mappers.scale.ScaleMapper;
import com.puntopago.ppa.infrastructure.adapters.out.database.repository.ScaleRepository;
import com.puntopago.ppa.infrastructure.ports.out.scale.ScalePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ScaleAdapter implements ScalePort {

    private final ScaleMapper mapper;

    private final ScaleRepository repository;

    @Override
    public List<Scale> saveAll(List<Scale> scales) {
        List<ScaleEntity> scaleEntities = mapper.domainsToEntities(scales);
        return mapper.entitiesToDomains(repository.saveAll(scaleEntities));
    }

    @Override
    public List<Scale> findByItinerary(Long itineraryId) {
        return mapper.entitiesToDomains(repository.findByItinerary(itineraryId));
    }

    @Override
    public void delete(Long scale) throws ApiException {
        ScaleNotFoundException errorNotFound = new ScaleNotFoundException();
        errorNotFound.addParams(new Object[]{scale});
        ScaleEntity entity = repository.findById(scale).orElseThrow(() -> errorNotFound);
        repository.delete(entity);
    }
}
