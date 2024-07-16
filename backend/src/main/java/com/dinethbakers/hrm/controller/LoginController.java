package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.model.LoginRequest;
import com.dinethbakers.hrm.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;


    @PostMapping
    public ResponseEntity<Map<String, Object>> validateLogin(@RequestBody LoginRequest dto){
        return loginService.validateLogin(dto);
    }

}
