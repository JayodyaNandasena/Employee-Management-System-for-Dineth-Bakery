package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeOffRequestRead {
    private EmployeeCreate employee;
    private String text;
    private LocalDateTime requestDateTime;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Status status;
}
