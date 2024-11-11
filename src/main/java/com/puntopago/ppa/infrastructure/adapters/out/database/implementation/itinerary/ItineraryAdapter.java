package com.puntopago.ppa.infrastructure.adapters.out.database.implementation.itinerary;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.application.exceptions.itinerary.ItineraryNotFoundException;
import com.puntopago.ppa.domain.models.Itinerary;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.ItineraryEntity;
import com.puntopago.ppa.infrastructure.adapters.out.database.mappers.itinerary.ItineraryMapper;
import com.puntopago.ppa.infrastructure.adapters.out.database.repository.ItineraryRepository;
import com.puntopago.ppa.infrastructure.ports.out.itinerary.ItineraryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItineraryAdapter implements ItineraryPort {

    private final ItineraryMapper mapper;

    private final ItineraryRepository repository;

    @Override
    public Itinerary save(Itinerary itinerary) {
        ItineraryEntity entity = mapper.domainToEntity(itinerary);
        return mapper.entityToDomain(repository.save(entity));
    }

    @Override
    public Itinerary update(Itinerary itinerary) throws ApiException {
        ItineraryNotFoundException errorNotFound = new ItineraryNotFoundException();
        errorNotFound.addParams(new Object[]{itinerary.getId()});
        ItineraryEntity target = repository.findById(itinerary.getId()).orElseThrow(() -> errorNotFound);
        mapper.mergeToEntity(target, itinerary);
        return mapper.entityToDomain(repository.save(target));
    }

    @Override
    public Itinerary findById(Long id) throws ApiException {
        ItineraryNotFoundException errorNotFound = new ItineraryNotFoundException();
        errorNotFound.addParams(new Object[]{id});
        return mapper.entityToDomain(repository.findById(id).orElseThrow(() -> errorNotFound));
    }

}
