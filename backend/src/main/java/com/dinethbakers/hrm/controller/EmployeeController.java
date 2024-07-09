package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.model.EmployeeCreate;
import com.dinethbakers.hrm.model.EmployeeRead;
import com.dinethbakers.hrm.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeRead persist(@RequestBody EmployeeCreate dto){
        return employeeService.persist(dto);
    }

    @GetMapping("/by-id")
    public EmployeeRead getById(@RequestParam String id){
        return employeeService.getById(id);
    }
}
