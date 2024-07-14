package com.dinethbakers.hrm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.dinethbakers.hrm.util.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class EmployeeEntity {
    @Id
    @Column(name = "employee_id")
    private String employeeId;
    private String firstName;
    private String lastName;
    private String nic;
    private LocalDate dob;
    private String profilePicture;
    private LocalDate hiredDate;
    private String address;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonIgnore
    @OneToOne(mappedBy = "employee")
    private AccountEntity account;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id")
    private BranchEntity branch;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeMobileEntity> mobileNumbers;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttendanceEntity> attendanceRecords;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_role_id", referencedColumnName = "job_role_id")
    private JobRoleEntity jobRole;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    List<TimeOffEntity> timeOffList;

    @JsonIgnore
    @ManyToMany(mappedBy = "employees")
    private List<MessageEntity> messages;

}
