package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.Status;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Attendance {
    private Integer attendanceId;
    private LocalDate date;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private Status status;

}
