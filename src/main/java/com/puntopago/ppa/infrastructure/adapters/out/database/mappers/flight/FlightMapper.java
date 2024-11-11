package com.puntopago.ppa.infrastructure.adapters.out.database.mappers.flight;

import com.puntopago.ppa.domain.models.Flight;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.FlightEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FlightMapper {

    Flight entityToDomain(FlightEntity entity);

    FlightEntity domainToEntity(Flight domain);

    List<Flight> entitiesToDomains(List<FlightEntity> entities);

}
