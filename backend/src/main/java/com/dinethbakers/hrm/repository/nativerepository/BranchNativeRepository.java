package com.dinethbakers.hrm.repository.nativerepository;

import com.dinethbakers.hrm.entity.BranchEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BranchNativeRepository {
    List<Map<String, Object>> findByName(String name);
    Optional<BranchEntity> findByLocation(BigDecimal latitude, BigDecimal longitude);
    String getLastId();
    Optional<BranchEntity> update(BranchEntity entity);
}
