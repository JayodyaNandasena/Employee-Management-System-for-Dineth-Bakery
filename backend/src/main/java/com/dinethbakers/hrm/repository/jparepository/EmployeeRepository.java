package com.dinethbakers.hrm.repository.jparepository;

import com.dinethbakers.hrm.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,String> {
    @Query("SELECT max(e.employeeId) FROM EmployeeEntity e")
    String findMaxEmployeeId();
}
