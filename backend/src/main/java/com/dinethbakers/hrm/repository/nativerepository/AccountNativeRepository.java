package com.dinethbakers.hrm.repository.nativerepository;

import com.dinethbakers.hrm.entity.AccountEntity;
import org.springframework.transaction.annotation.Transactional;

public interface AccountNativeRepository {
    @Transactional
    AccountEntity editAccount(AccountEntity account);
}
