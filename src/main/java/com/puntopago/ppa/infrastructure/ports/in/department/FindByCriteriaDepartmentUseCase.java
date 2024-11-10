package com.puntopago.ppa.infrastructure.ports.in.department;

import com.puntopago.ppa.domain.filters.DepartmentFilter;
import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.domain.records.PageModel;

import java.util.List;

public interface FindByCriteriaDepartmentUseCase {

    PageModel<List<Department>> execute(DepartmentFilter filter);
}
