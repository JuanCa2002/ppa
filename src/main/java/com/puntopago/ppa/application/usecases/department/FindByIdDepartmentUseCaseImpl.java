package com.puntopago.ppa.application.usecases.department;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.infrastructure.ports.in.department.FindByIdDepartmentUseCase;
import com.puntopago.ppa.infrastructure.ports.out.department.DepartmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindByIdDepartmentUseCaseImpl implements FindByIdDepartmentUseCase {

    private final DepartmentPort port;

    @Transactional(readOnly = true)
    @Override
    public Department execute(Long id) throws ApiException {
        return port.findById(id);
    }
}
