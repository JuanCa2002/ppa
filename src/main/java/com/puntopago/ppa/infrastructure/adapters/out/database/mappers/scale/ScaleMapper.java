package com.puntopago.ppa.infrastructure.adapters.out.database.mappers.scale;

import com.puntopago.ppa.domain.models.Scale;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.ScaleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScaleMapper {

    Scale entityToDomain(ScaleEntity entity);

    ScaleEntity domainToEntity(Scale domain);

    List<Scale> entitiesToDomains(List<ScaleEntity> entities);

    List<ScaleEntity> domainsToEntities(List<Scale> domains);
}
