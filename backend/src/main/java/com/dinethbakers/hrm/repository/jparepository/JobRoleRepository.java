package com.dinethbakers.hrm.repository.jparepository;

import com.dinethbakers.hrm.entity.JobRoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JobRoleRepository extends CrudRepository<JobRoleEntity,String> {
    @Query("SELECT max(j.jobRoleId) FROM JobRoleEntity j")
    String findMaxJobRoleId();
}
