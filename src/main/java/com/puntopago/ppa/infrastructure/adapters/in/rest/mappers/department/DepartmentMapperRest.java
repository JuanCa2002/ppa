package com.puntopago.ppa.infrastructure.adapters.in.rest.mappers.department;

import com.puntopago.ppa.domain.filters.DepartmentFilter;
import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department.DepartmentRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department.UpdateDepartmentRequest;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.request.department.filters.DepartmentRqFilter;
import com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response.department.DepartmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapperRest {

    Department requestToDomain(DepartmentRequest request);

    DepartmentResponse domainToResponse(Department domain);

    Department updateRequestToDomain(UpdateDepartmentRequest request);

    DepartmentFilter rqFilterToDomain(DepartmentRqFilter rqFilter);

    List<DepartmentResponse> domainsToResponses(List<Department> domains);
}
