package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.model.JobRole;
import com.dinethbakers.hrm.service.JobRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RequestMapping("/jobrole")
@RestController
public class JobRoleController {
    private final JobRoleService jobRoleService;

    @PostMapping
    public void persist(@RequestBody JobRole jobRole){
        //to be implemented
    }
}
