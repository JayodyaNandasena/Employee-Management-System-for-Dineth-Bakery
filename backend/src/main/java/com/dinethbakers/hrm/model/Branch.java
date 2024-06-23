package com.dinethbakers.hrm.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Branch {
    private Integer branchId;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String address;
}
