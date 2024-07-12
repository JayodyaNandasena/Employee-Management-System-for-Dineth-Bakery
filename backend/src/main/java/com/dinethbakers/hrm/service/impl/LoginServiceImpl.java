package com.dinethbakers.hrm.service.impl;

import com.dinethbakers.hrm.entity.AccountEntity;
import com.dinethbakers.hrm.model.AccountRead;
import com.dinethbakers.hrm.model.LoginRequest;
import com.dinethbakers.hrm.repository.jparepository.AccountRepository;
import com.dinethbakers.hrm.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final AccountRepository accountRepository;
    private final ObjectMapper mapper;
    @Override
    public ResponseEntity<Map<String, Object>> validateLogin(LoginRequest dto) {
        Optional<AccountEntity> byId = accountRepository.findById(dto.getUsername());

        Map<String, Object> result = new HashMap<>();
        String key = "status";

        if (byId.isPresent()) {
            AccountEntity accountEntity = byId.get();

            if(Boolean.TRUE.equals(checkPassword(dto.getPassword(), accountEntity.getPassword()))){
                result.put(key, true);
                result.put("employeeDetails", mapper.convertValue(accountEntity, AccountRead.class));
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            result.put(key, false);
            result.put("message", "Invalid password");
            return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
        }
        result.put(key, false);
        result.put("message", "User not found");
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    private Boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
