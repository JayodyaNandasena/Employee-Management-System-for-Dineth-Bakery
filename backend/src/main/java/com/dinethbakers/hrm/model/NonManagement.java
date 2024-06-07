package com.dinethbakers.hrm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NonManagement extends Employee {
    private Management manager;
}
