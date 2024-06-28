package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.Gender;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String nic;
    private String name;
    private LocalDate dob;
    private String profilePicture;
    private LocalDate hiredDate;
    private String address;
    private String email;
    private Gender gender;
    private Account account;
    private Branch branch;
    private List<EmployeeMobile> mobileNumbers;
    private List<Attendance> attendanceRecords;
    private JobRole jobRole;
    List<TimeOff> timeOffList;
    private List<Message> messages;
}
