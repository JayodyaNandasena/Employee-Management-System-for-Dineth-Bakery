package com.dinethbakers.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "account")
@Data
public class AccountEntity {
    @Id
    private String username;
    private String password;
    @Column(columnDefinition = "boolean default false")
    private Boolean isManager;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ToString.Exclude
    private EmployeeEntity employee;
}
