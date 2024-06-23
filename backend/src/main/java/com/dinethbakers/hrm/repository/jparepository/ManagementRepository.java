package com.dinethbakers.hrm.repository.jparepository;

import com.dinethbakers.hrm.entity.ManagementEntity;
import org.springframework.data.repository.CrudRepository;

public interface ManagementRepository extends CrudRepository<ManagementEntity,String> {
}
