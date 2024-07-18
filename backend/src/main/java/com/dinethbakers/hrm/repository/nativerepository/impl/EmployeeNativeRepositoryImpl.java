package com.dinethbakers.hrm.repository.nativerepository.impl;

import com.dinethbakers.hrm.entity.EmployeeEntity;
import com.dinethbakers.hrm.repository.jparepository.EmployeeRepository;
import com.dinethbakers.hrm.repository.nativerepository.EmployeeNativeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class EmployeeNativeRepositoryImpl implements EmployeeNativeRepository {
    private final JdbcTemplate jdbcTemplate;
    private final EmployeeRepository jpaRepository;
    @Override
    public EmployeeEntity editEmployee(EmployeeEntity updatedEmployee) {
        String sql = "UPDATE employee SET first_name = ?, " +
                "last_name = ?, nic = ?, dob = ?, profile_picture = ?, " +
                "hired_date = ?, address = ?, email = ?, gender = ?, " +
                "branch_id = ?, job_role_id = ? WHERE employee_id = ?";

        int rowsAffected = jdbcTemplate.update(sql,
                updatedEmployee.getFirstName(),
                updatedEmployee.getLastName(),
                updatedEmployee.getNic(),
                updatedEmployee.getDob(),
                updatedEmployee.getProfilePicture(),
                updatedEmployee.getHiredDate(),
                updatedEmployee.getAddress(),
                updatedEmployee.getEmail(),
                updatedEmployee.getGender(),
                updatedEmployee.getBranch(),
                updatedEmployee.getJobRole(),
                updatedEmployee.getEmployeeId());

        if (rowsAffected > 0) {
            return jpaRepository.findById(updatedEmployee.getEmployeeId()).get();
        } else {
            return null; // or throw an exception if preferred
        }
    }
}
