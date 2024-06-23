package com.dinethbakers.hrm.service;

import com.dinethbakers.hrm.model.Branch;

import java.math.BigDecimal;
import java.util.List;

public interface BranchService {
    Branch persist(Branch branch);
    Branch getById(String id);
    List<Branch> getByName(String name);
    Branch getByLocation(BigDecimal latitude, BigDecimal longitude);
    List<Branch> getAll();
    Branch update(Branch branch);
    Boolean delete(String id);
}
