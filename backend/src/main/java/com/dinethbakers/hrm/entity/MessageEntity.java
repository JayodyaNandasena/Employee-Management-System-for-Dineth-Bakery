package com.dinethbakers.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "messages")
@Data
public class MessageEntity {
    @Id
    @Column(name = "message_id")
    private String messageId;
    private LocalDate date;
    private LocalTime time;
    private String text;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "employee_id")
    private ManagementEntity sender;

    @ManyToMany
    @JoinTable(name = "employee_message",
            joinColumns = @JoinColumn(name = "message_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<EmployeeEntity> employees;

}
