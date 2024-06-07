package com.dinethbakers.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class AccountEntity {
    @Id
    private String username;
    private String password;
    private Boolean isManager;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private EmployeeEntity employee;
}
