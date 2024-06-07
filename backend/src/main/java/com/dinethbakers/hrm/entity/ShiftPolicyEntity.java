package com.dinethbakers.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "shift_policy")
@Data
public class ShiftPolicyEntity {
    @Id
    @Column(name = "policy_id")
    private Long policyId;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToMany(mappedBy = "shiftPolicies")
    private List<JobRoleEntity> jobRoles;
}
