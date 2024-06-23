package com.dinethbakers.hrm.repository.nativerepository.impl;

import com.dinethbakers.hrm.entity.BranchEntity;
import com.dinethbakers.hrm.repository.nativerepository.BranchNativeRepository;
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

    @Override
    public String getLastId(){
        List<String> ids = jdbcTemplate.queryForList(
                "SELECT branch_id FROM BRANCH ORDER BY branch_id ASC LIMIT 1",
                String.class
        );

        if (ids.isEmpty()) {
            return null;
        } else {
            return ids.get(0);
        }
    }

    @Override
    public Optional<BranchEntity> update(BranchEntity entity){
        String sql = "UPDATE BRANCH " +
                " SET " +
                "    name = ?," +
                "    latitude = ?," +
                "    longitude = ?," +
                "    address = ?" +
                " WHERE " +
                "    branch_id = ?";

        int rowsUpdated = jdbcTemplate.update(sql,
                entity.getName(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getAddress(),
                entity.getBranchId());

        if (rowsUpdated > 0) {
            return Optional.of(entity);
        } else {
            return Optional.empty();
        }
    }


}
