package com.puntopago.ppa.infrastructure.adapters.out.database.mappers.itinerary;

import com.puntopago.ppa.domain.models.Itinerary;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.ItineraryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItineraryMapper {

    Itinerary entityToDomain(ItineraryEntity entity);

    ItineraryEntity domainToEntity(Itinerary domain);

    void mergeToEntity(@MappingTarget ItineraryEntity target, Itinerary source);
}
