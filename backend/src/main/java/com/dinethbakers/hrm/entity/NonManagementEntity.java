package com.dinethbakers.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "non_management_employees")
@Data
@EqualsAndHashCode(callSuper = true)
public class NonManagementEntity extends EmployeeEntity {

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private ManagementEntity manager;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OverTimeEntity> overtimeList;


}
