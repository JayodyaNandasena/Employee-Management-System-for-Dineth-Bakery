package com.dinethbakers.hrm.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LeavePolicy {
    private String policyId;
    private Integer noOfPTODays;
    private BigDecimal deductionPerExtraDay;
}
