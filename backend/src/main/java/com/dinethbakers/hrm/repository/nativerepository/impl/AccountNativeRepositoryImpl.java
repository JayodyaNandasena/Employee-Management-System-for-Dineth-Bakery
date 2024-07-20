package com.dinethbakers.hrm.repository.nativerepository.impl;

import com.dinethbakers.hrm.entity.AccountEntity;
import com.dinethbakers.hrm.repository.jparepository.AccountRepository;
import com.dinethbakers.hrm.repository.nativerepository.AccountNativeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class AccountNativeRepositoryImpl implements AccountNativeRepository {
    private final JdbcTemplate jdbcTemplate;
    private final AccountRepository jpaRepository;

    @Override
    @Transactional
    public AccountEntity editAccount(AccountEntity account) {
        String sql = "UPDATE account SET username = ?, password = ?, is_manager = ? WHERE employee_id = ?";
        int rowsAffected = jdbcTemplate.update(sql,
                account.getUsername(),
                account.getPassword(),
                account.getIsManager(),
                account.getEmployee().getEmployeeId());

        if (rowsAffected > 0) {
            return jpaRepository.findById(account.getUsername())
                    .orElseThrow(() -> new EntityNotFoundException("Account not found with username: " + account.getUsername()));
        } else {
            return null;
        }
    }

}
