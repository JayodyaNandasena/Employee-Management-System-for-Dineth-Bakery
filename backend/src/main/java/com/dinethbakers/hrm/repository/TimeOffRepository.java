package com.dinethbakers.hrm.repository;

import com.dinethbakers.hrm.entity.TimeOffEntity;
import org.springframework.data.repository.CrudRepository;

public interface TimeOffRepository extends CrudRepository<TimeOffEntity,String> {
}
