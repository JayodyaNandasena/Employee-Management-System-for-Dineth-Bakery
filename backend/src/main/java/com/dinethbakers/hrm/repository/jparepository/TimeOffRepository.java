package com.dinethbakers.hrm.repository.jparepository;

import com.dinethbakers.hrm.entity.TimeOffEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TimeOffRepository extends CrudRepository<TimeOffEntity,String> {
    @Query("SELECT max(t.requestId) FROM TimeOffEntity t")
    String findMaxTimeOffRequestId();
}
