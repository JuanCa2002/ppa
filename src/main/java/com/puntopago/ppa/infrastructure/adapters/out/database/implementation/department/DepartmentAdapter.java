package com.puntopago.ppa.infrastructure.adapters.out.database.implementation.department;

import com.puntopago.ppa.application.exceptions.department.DepartmentNotFoundException;
import com.puntopago.ppa.application.exceptions.general.ApiException;
import com.puntopago.ppa.domain.enums.State;
import com.puntopago.ppa.domain.models.Department;
import com.puntopago.ppa.domain.records.PageModel;
import com.puntopago.ppa.infrastructure.adapters.out.database.entities.DepartmentEntity;
import com.puntopago.ppa.infrastructure.adapters.out.database.mappers.department.DepartmentMapper;
import com.puntopago.ppa.infrastructure.adapters.out.database.repository.DepartmentRepository;
import com.puntopago.ppa.infrastructure.ports.out.department.DepartmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentAdapter implements DepartmentPort {

    private final DepartmentRepository repository;

    private final DepartmentMapper mapper;

    @Override
    public Department save(Department department) {
        DepartmentEntity entity = mapper.domainToEntity(department);
        return mapper.entityToDomain(repository.save(entity));
    }

    @Override
    public Department update(Department department) throws ApiException {
        DepartmentNotFoundException errorNotFound = new DepartmentNotFoundException();
        errorNotFound.addParams(new Object[]{department.getId()});
        DepartmentEntity target = repository.findById(department.getId()).orElseThrow(() -> errorNotFound);
        mapper.mergeToEntity(target, department);
        return mapper.entityToDomain(repository.save(target));
    }

    @Override
    public Department findById(Long id) throws ApiException {
        DepartmentNotFoundException errorNotFound = new DepartmentNotFoundException();
        errorNotFound.addParams(new Object[]{id});
        return mapper.entityToDomain(repository.findById(id).orElseThrow(() -> errorNotFound));
    }

    @Override
    public PageModel<List<Department>> findByCriteria(String name, State state, Integer rowsPerPage, Integer skip) {
        int pageNumber = (int) Math.ceil((double)skip/rowsPerPage);
        Pageable pageable = rowsPerPage == 0 ? Pageable.unpaged() : PageRequest.of(pageNumber, rowsPerPage);

        Page<DepartmentEntity> page = repository.findByCriteria(name != null ? name.toUpperCase(): null, state, pageable);
        return new PageModel<>(mapper.entitiesToDomains(page.getContent()), BigInteger.valueOf(page.getTotalElements()));
    }
}
