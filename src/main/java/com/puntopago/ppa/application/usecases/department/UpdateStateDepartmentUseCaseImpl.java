package com.puntopago.ppa.application.usecases.department;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.infrastructure.ports.in.department.UpdateStateDepartmentUseCase;
import com.puntopago.ppa.infrastructure.ports.out.department.DepartmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateStateDepartmentUseCaseImpl implements UpdateStateDepartmentUseCase {

    private final DepartmentPort port;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Department execute(Long id) throws ApiException {
        Department foundDepartment = port.findById(id);
        foundDepartment.setState(foundDepartment.getState().equals(State.ACTIVE) ? State.INACTIVE: State.ACTIVE);
        return port.update(foundDepartment);
    }
}
