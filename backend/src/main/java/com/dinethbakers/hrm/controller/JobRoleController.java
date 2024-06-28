package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.service.JobRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RequestMapping("/jobrole")
@RestController
public class JobRoleController {
    private final JobRoleService jobRoleService;
}
