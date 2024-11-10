package com.puntopago.ppa.application.usecases.department;

import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.infrastructure.ports.in.department.CreateDepartmentUseCase;
import com.puntopago.ppa.infrastructure.ports.out.department.DepartmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateDepartmentUseCaseImpl implements CreateDepartmentUseCase {

    private final DepartmentPort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Department execute(Department department) {
        department.setId(null);
        department.setState(State.ACTIVE);
        return port.save(department);
    }
}
