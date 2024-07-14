package com.dinethbakers.hrm.model;

import lombok.Data;

@Data
public class Salary {
    private Double basicSalary;
    private Double epfPercentage;
    private Double epfAmount;
    private Double etfPercentage;
    private Double etfAmount;
    private Double otHours;
    private Double otPerHour;
    private Double grossOTIncome;
    private Double grossEarnings;
    private Double grossDeductions;
    private Double grossSalary;

}
