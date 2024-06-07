package com.dinethbakers.hrm.model;

import com.dinethbakers.hrm.util.Gender;
import lombok.Data;

import java.time.LocalDate;

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
}
