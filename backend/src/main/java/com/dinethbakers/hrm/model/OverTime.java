package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.Status;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class OverTime {
    private String requestId;
    private LocalDateTime date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double paymentAmount;
    private Status status;
    private LocalDateTime approvedDateTime;
}