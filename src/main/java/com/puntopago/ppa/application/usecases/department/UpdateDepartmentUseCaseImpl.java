package com.puntopago.ppa.application.usecases.department;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.infrastructure.ports.in.department.UpdateDepartmentUseCase;
import com.puntopago.ppa.infrastructure.ports.out.department.DepartmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateDepartmentUseCaseImpl implements UpdateDepartmentUseCase {

    private final DepartmentPort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Department execute(Department department) throws ApiException {
        return port.update(department);
    }
}
