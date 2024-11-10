package com.puntopago.ppa.application.exceptions.department;

import com.puntopago.ppa.application.exceptions.general.NotFoundException;

public class DepartmentNotFoundException extends NotFoundException {

    public DepartmentNotFoundException() {
        super(DepartmentApiErrorMessages.DEPARTMENT_NOT_FOUND);
    }
}
