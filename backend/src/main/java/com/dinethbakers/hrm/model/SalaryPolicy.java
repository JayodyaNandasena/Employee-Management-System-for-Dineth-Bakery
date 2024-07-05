package com.dinethbakers.hrm.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalaryPolicy {
    private Integer policyId;
    private BigDecimal monthlyBasicSalary;
    private BigDecimal overtimeSalaryPerHour;
    private BigDecimal epfPercentage;
    private BigDecimal etfPercentage;
}
