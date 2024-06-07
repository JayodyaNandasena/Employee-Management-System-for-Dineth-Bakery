package com.dinethbakers.hrm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "leave_policy")
@Data
public class LeavePolicyEntity {
    @Id
    @Column(name = "policy_id")
    private String policyId;
    private Integer noOfPTODays;

    @Column(precision = 10, scale = 2)
    private BigDecimal deductionPerExtraDay;

    @JsonIgnore
    @OneToMany(mappedBy = "leavePolicy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobRoleEntity> jobRoles;


}
