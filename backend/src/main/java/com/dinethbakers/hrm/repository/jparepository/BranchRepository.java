package com.dinethbakers.hrm.repository.jparepository;

import com.dinethbakers.hrm.entity.BranchEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BranchRepository extends CrudRepository<BranchEntity,String> {
}
