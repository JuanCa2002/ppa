package com.puntopago.ppa.infrastructure.ports.out.department;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.domain.records.PageModel;

import java.util.List;

public interface DepartmentPort {

    Department save(Department department);

    Department update(Department department) throws ApiException;

    Department findById(Long id) throws ApiException;

    PageModel<List<Department>> findByCriteria(String name, State state, Integer rowsPerPage, Integer skip);
}
