package com.puntopago.ppa.infrastructure.adapters.out.database.mappers.municipality;

import com.puntopago.ppa.domain.models.Municipality;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.MunicipalityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MunicipalityMapper {

    Municipality entityToDomain(MunicipalityEntity entity);

    MunicipalityEntity domainToEntity(Municipality domain);

    void mergeToEntity(@MappingTarget MunicipalityEntity target, Municipality source);

    List<Municipality> entitiesToDomains(List<MunicipalityEntity> entities);
}
