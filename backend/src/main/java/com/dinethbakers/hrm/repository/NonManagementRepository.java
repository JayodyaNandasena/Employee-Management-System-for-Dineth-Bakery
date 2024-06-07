package com.dinethbakers.hrm.repository;

import com.dinethbakers.hrm.entity.NonManagementEntity;
import org.springframework.data.repository.CrudRepository;

public interface NonManagementRepository extends CrudRepository<NonManagementEntity,String> {
}
