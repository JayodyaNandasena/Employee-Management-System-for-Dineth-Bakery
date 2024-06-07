package com.dinethbakers.hrm.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "management_employees")
@Data
@EqualsAndHashCode(callSuper = true)
public class ManagementEntity extends EmployeeEntity {
    private String managementLevel;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    List<MessageEntity> messageList;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OverTimeEntity> overtimeList;

}
