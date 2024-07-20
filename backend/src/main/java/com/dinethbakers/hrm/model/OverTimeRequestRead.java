package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.Status;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class OverTimeRequestRead {
    private String requestId;
    private EmployeeCreate employee;
    private LocalDateTime date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String text;
    private Status status;
}
