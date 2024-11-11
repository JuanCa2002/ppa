package com.puntopago.ppa.infrastructure.adapters.out.database.mappers.airport;

import com.puntopago.ppa.domain.models.Airport;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.AirportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirportMapper {

    Airport entityToDomain(AirportEntity entity);

    AirportEntity domainToEntity(Airport domain);

    List<Airport> entitiesToDomains(List<AirportEntity> entities);

    void mergeToEntity(@MappingTarget AirportEntity target, Airport source);
}
