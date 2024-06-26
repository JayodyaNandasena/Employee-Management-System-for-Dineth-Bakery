package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeOff {
    private String requestId;
    private String text;
    private LocalDateTime requestDateTime;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Boolean isPaid;
    private Status status;
    private LocalDateTime approvedDateTime;
}
