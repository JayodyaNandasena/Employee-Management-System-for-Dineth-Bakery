package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.ShiftType;
import lombok.Data;
import java.util.List;

@Data
public class JobRole {
    private String title;
    private LeavePolicy leavePolicy;
    private SalaryPolicy salaryPolicy;
    private ShiftType shiftType;
    private List<ShiftPolicy> shiftPolicies;
}
