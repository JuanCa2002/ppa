package com.puntopago.ppa.infrastructure.adapters.out.database.mappers.department;

import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    Department entityToDomain(DepartmentEntity entity);

    DepartmentEntity domainToEntity(Department domain);

    void mergeToEntity(@MappingTarget DepartmentEntity target, Department source);

    List<Department> entitiesToDomains(List<DepartmentEntity> entities);
}
