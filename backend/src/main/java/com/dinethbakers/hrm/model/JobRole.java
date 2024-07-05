package com.dinethbakers.hrm.model;

import lombok.Data;
import java.util.List;

@Data
public class JobRole {
    private String jobRoleId;
    private String title;
    //private List<Employee> employees;
    private LeavePolicy leavePolicy;
    private SalaryPolicy salaryPolicy;
    private List<ShiftPolicy> shiftPolicies;
}
