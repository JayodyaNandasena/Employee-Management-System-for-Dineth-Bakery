package com.dinethbakers.hrm.repository.jparepository;

import com.dinethbakers.hrm.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,String> {
}
