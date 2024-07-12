package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeCreate {
    private String firstName;
    private String lastName;
    private String nic;
    private LocalDate dob;
    private String profilePicture;
    private LocalDate hiredDate;
    private String address;
    private String email;
    private Gender gender;
    private String branchName;
    private String jobRoleTitle;
    private AccountCreate account;
    //private List<EmployeeMobile> mobileNumbers;
    //private List<Attendance> attendanceRecords;
    //List<TimeOff> timeOffList;
    //private List<Message> messages;
}
