package com.dinethbakers.hrm.model;

import lombok.Data;

@Data
public class Account {
    private String username;
    private String password;
    private Boolean isManager;
}
