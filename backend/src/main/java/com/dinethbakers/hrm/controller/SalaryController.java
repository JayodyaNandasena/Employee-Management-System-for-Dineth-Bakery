package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.model.Salary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryController {
    @PostMapping
    public void getSalary(@RequestBody Salary dto){}
}
