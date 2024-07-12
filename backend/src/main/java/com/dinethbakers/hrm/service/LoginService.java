package com.dinethbakers.hrm.service;

import com.dinethbakers.hrm.model.LoginRequest;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface LoginService {
    ResponseEntity<Map<String, Object>> validateLogin(LoginRequest dto);
}
