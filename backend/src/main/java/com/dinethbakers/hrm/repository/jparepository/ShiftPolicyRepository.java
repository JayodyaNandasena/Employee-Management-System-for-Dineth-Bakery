package com.dinethbakers.hrm.repository.jparepository;

import com.dinethbakers.hrm.entity.ShiftPolicyEntity;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalTime;
import java.util.Optional;

public interface ShiftPolicyRepository extends CrudRepository<ShiftPolicyEntity,String> {
    Optional<ShiftPolicyEntity> findByStartTimeAndEndTime(
            LocalTime startTime, LocalTime endTime);
}
