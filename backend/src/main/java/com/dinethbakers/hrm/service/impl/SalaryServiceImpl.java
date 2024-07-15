package com.dinethbakers.hrm.service.impl;

import com.dinethbakers.hrm.entity.EmployeeEntity;
import com.dinethbakers.hrm.entity.SalaryPolicyEntity;
import com.dinethbakers.hrm.model.Salary;
import com.dinethbakers.hrm.repository.jparepository.EmployeeRepository;
import com.dinethbakers.hrm.repository.jparepository.OverTimeRepository;
import com.dinethbakers.hrm.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    private final EmployeeRepository employeeRepository;
    private final OverTimeRepository overTimeRepository;
    @Override
    public Salary getSalarySlip(String employeeId) {
        Optional<EmployeeEntity> byId = employeeRepository.findById(employeeId);

        if (byId.isEmpty()){
            return null;
        }
        SalaryPolicyEntity salaryPolicy = byId.get().getJobRole().getSalaryPolicy();

        BigDecimal basicSalary = salaryPolicy.getMonthlyBasicSalary();
        BigDecimal epfPercentage = salaryPolicy.getEpfPercentage();
        BigDecimal etfPercentage = salaryPolicy.getEtfPercentage();

        BigDecimal epfSalary = basicSalary.multiply(epfPercentage).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal etfSalary = basicSalary.multiply(etfPercentage).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal totalDeductions = epfSalary.add(etfSalary);

        BigDecimal otPerHour = salaryPolicy.getOvertimeSalaryPerHour();

        BigDecimal otPayment = overTimeRepository.findTotalOvertimePaymentByEmployeeId(employeeId);
        if (otPayment == null) {
            otPayment = BigDecimal.ZERO;
        }

        // Divide the payment amount by the overtime salary per hour to get the OT hours
        BigDecimal otHours = otPayment.divide(otPerHour, 2, RoundingMode.HALF_UP);

        BigDecimal grossSalary = basicSalary.add(otPayment);

        BigDecimal netSalary = grossSalary.subtract(totalDeductions);

        return new Salary(
                basicSalary,
                epfPercentage,
                epfSalary,
                etfPercentage,
                etfSalary,
                otHours,
                otPerHour,
                otPayment,
                grossSalary,
                totalDeductions,
                netSalary
        );
    }
}
