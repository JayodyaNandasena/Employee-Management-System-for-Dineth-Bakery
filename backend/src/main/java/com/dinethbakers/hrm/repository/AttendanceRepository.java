package com.dinethbakers.hrm.repository;

import com.dinethbakers.hrm.entity.AttendanceEntity;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<AttendanceEntity,String> {
}
