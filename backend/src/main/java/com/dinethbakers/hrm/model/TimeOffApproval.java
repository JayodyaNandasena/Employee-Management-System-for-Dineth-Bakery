package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.Status;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TimeOffApproval {
    private String managerId;
    private String requestId;
    private Status status;
    private LocalDateTime approvedDateTime;
}
