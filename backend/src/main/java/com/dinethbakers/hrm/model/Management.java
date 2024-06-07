package com.dinethbakers.hrm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Management extends Employee {
    private String managementLevel;
}
