package com.dinethbakers.hrm.repository;

import com.dinethbakers.hrm.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity,String> {
}
