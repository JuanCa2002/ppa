package com.puntopago.ppa.application.usecases.department;

import com.puntopago.ppa.domain.filters.DepartmentFilter;
import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.domain.records.PageModel;
import com.puntopago.ppa.infrastructure.ports.in.department.FindByCriteriaDepartmentUseCase;
import com.puntopago.ppa.infrastructure.ports.out.department.DepartmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindByCriteriaDepartmentUseCaseImpl implements FindByCriteriaDepartmentUseCase {

    private final DepartmentPort port;

    @Transactional(readOnly = true)
    @Override
    public PageModel<List<Department>> execute(DepartmentFilter filter) {
        return port.findByCriteria(filter.getName(), filter.getState(), filter.getRowsPerPage(), filter.getSkip());
    }
}
