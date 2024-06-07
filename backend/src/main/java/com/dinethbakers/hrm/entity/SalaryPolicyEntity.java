package com.dinethbakers.hrm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "salary_policy")
@Data
public class SalaryPolicyEntity {
    @Id
    @Column(name = "policy_id")
    private String policyId;
    private Double weeklyHoursNeeded;

    @Column(precision = 10, scale = 2)
    private BigDecimal basicSalaryPerHour;

    @Column(precision = 10, scale = 2)
    private BigDecimal overtimeSalaryPerHour;

    private Double maxOTPerMonth;

    @JsonIgnore
    @OneToMany(mappedBy = "salaryPolicy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobRoleEntity> jobRoles;




}
