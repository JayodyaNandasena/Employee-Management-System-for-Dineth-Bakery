package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.ShiftType;
import lombok.Data;
import java.util.List;

@Data
public class JobRole {
    private String jobRoleId;
    private String title;
    //private List<Employee> employees;
    private LeavePolicy leavePolicy;
    private SalaryPolicy salaryPolicy;

    private ShiftType shiftType;
    private List<ShiftPolicy> shiftPolicies;
}
