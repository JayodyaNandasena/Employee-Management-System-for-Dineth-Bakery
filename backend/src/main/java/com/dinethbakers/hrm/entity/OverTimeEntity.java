package com.dinethbakers.hrm.entity;

import com.dinethbakers.hrm.util.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "over_time")
@Data
public class OverTimeEntity {
    @Id
    @Column(name = "policy_id")
    private String requestId;
    private LocalDateTime date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double paymentAmount;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime approvedDateTime;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requester_id", referencedColumnName = "employee_id")
    private NonManagementEntity employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "approver_id", referencedColumnName = "employee_id")
    private ManagementEntity manager;


}