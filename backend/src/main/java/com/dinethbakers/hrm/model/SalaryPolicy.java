package com.dinethbakers.hrm.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalaryPolicy {
    private String policyId;
    private Double weeklyHoursNeeded;
    private BigDecimal basicSalaryPerHour;
    private BigDecimal overtimeSalaryPerHour;
    private Double maxOTPerMonth;
}
