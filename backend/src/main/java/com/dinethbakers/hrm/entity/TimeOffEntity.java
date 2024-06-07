package com.dinethbakers.hrm.entity;

import com.dinethbakers.hrm.util.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name = "time_off")
@Data
public class TimeOffEntity {
    @Id
    private String requestId;
    private String text;
    private LocalDateTime requestDateTime;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Boolean isPaid;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime approvedDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "approved_manager_id", referencedColumnName = "employee_id")
    private ManagementEntity manager;


}
