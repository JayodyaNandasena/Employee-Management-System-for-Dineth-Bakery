package com.dinethbakers.hrm.service;

import com.dinethbakers.hrm.model.EmployeeCreate;
import com.dinethbakers.hrm.model.EmployeeRead;

public interface EmployeeService {
    EmployeeRead persist(EmployeeCreate dto);
    EmployeeRead getById(String id);
}
