package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.Status;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class OverTimeRequest {
    private String employeeId;
    private LocalDate date;
    private LocalDateTime requestDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String text;
    private Status status;
}
