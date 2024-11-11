package com.puntopago.ppa.infrastructure.adapters.out.database.mappers.airline;

import com.puntopago.ppa.domain.models.Airline;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.AirlineEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirlineMapper {

    Airline entityToDomain(AirlineEntity entity);

    AirlineEntity domainToEntity(Airline domain);

    void mergeToEntity(@MappingTarget AirlineEntity target, Airline source);

    List<Airline> entitiesToDomains(List<AirlineEntity> entities);
}
