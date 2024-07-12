package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.model.LoginRequest;
import com.dinethbakers.hrm.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> validateLogin(@RequestBody LoginRequest dto){
        return loginService.validateLogin(dto);
    }

}
