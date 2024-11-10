package com.puntopago.ppa.infrastructure.ports.in.department;

import com.puntopago.ppa.domain.models.Department;

public interface CreateDepartmentUseCase {

    Department execute(Department department);
}
