package com.dinethbakers.hrm.entity;

import com.dinethbakers.hrm.util.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance")
@Data
public class AttendanceEntity {
    @Id
    private String attendanceId;
    private LocalDate date;
    private LocalTime timeIn;
    private LocalTime timeOut;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private EmployeeEntity employee;
}
