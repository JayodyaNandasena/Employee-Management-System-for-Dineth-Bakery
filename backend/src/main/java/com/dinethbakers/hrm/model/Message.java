package com.dinethbakers.hrm.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Message {
    private String messageId;
    private LocalDate date;
    private LocalTime time;
    private String text;
}
