package com.puntopago.ppa.infrastructure.adapters.out.database.mappers.airplane;

import com.puntopago.ppa.domain.models.Airplane;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.AirplaneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirplaneMapper {

    Airplane entityToDomain(AirplaneEntity entity);

    AirplaneEntity domainToEntity(Airplane domain);

    List<Airplane> entitiesToDomains(List<AirplaneEntity> entities);

    void mergeToEntity(@MappingTarget AirplaneEntity target, Airplane source);
}
