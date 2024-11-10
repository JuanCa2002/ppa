package com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.municipality;

import com.puntopago.ppa.domain.filters.MunicipalityFilter;
import com.puntopago.ppa.domain.models.Municipality;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.municipality.MunicipalityRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.municipality.UpdateMunicipalityRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.municipality.filters.MunicipalityRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.municipality.MunicipalityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MunicipalityMapperRest {

    @Mapping(target = "department.id", source = "departmentId")
    Municipality requestToDomain(MunicipalityRequest request);

    MunicipalityResponse domainToResponse(Municipality domain);

    Municipality updateRequestToDomain(UpdateMunicipalityRequest request);

    MunicipalityFilter rqFilterToFilter(MunicipalityRqFilter filter);

    List<MunicipalityResponse> domainsToResponses(List<Municipality> domains);
}
