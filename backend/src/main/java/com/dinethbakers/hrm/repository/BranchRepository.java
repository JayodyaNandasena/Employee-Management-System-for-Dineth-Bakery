package com.dinethbakers.hrm.repository;

import com.dinethbakers.hrm.entity.BranchEntity;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<BranchEntity,String> {
}
