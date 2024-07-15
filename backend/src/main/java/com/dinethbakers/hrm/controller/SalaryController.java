package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.model.Salary;
import com.dinethbakers.hrm.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/salary")
public class SalaryController {
    private final SalaryService salaryService;
    @PostMapping
    public Salary getSalary(@RequestParam String employeeId){
        return salaryService.getSalarySlip(employeeId);
    }
}
