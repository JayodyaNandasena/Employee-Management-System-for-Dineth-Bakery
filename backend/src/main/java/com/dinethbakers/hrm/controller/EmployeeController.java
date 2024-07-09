package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.model.Employee;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    public Employee persist(@RequestBody Employee dto){
        return null;
    }
}
