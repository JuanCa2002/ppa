package com.puntopago.ppa.infrastructure.ports.in.department;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Department;

public interface FindByIdDepartmentUseCase {

    Department execute(Long id) throws ApiException;
}
