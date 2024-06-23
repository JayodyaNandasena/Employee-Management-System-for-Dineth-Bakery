package com.dinethbakers.hrm.repository.nativerepository.impl;

import com.dinethbakers.hrm.entity.BranchEntity;
import com.dinethbakers.hrm.repository.nativerepository.BranchNativeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BranchNativeRepositoryImpl implements BranchNativeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> findByName(String name) {
        return jdbcTemplate.queryForList(
                "SELECT * FROM BRANCH WHERE name LIKE '%" + name + "%'"
        );
    }

    @Override
    public Optional<BranchEntity> findByLocation(BigDecimal latitude, BigDecimal longitude) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "SELECT * FROM BRANCH WHERE latitude = '" + latitude + "'" +
                        " AND longitude = '" + longitude + "'"
                , BranchEntity.class));
    }

}
