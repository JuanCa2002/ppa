package com.puntopago.ppa.application.usecases.municipality;

import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.domain.models.Municipality;
import com.puntopago.ppa.infrastructure.ports.in.municipality.CreateMunicipalityUseCase;
import com.puntopago.ppa.infrastructure.ports.out.department.DepartmentPort;
import com.puntopago.ppa.infrastructure.ports.out.municipality.MunicipalityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateMunicipalityUseCaseImpl implements CreateMunicipalityUseCase {

    private final MunicipalityPort port;

    private final DepartmentPort departmentPort;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Municipality execute(Municipality municipality) throws ApiException {
        Department department = departmentPort.findById(municipality.getDepartment().getId());
        municipality.setId(null);
        municipality.setState(State.ACTIVE);
        Municipality savedMunicipality = port.save(municipality);
        savedMunicipality.setDepartment(department);
        return savedMunicipality;
    }
}
