package com.dinethbakers.hrm.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ShiftPolicy {
    private Integer policyId;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime totalHours;
}
