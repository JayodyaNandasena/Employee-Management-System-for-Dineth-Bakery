package com.dinethbakers.hrm.service.impl;

import com.dinethbakers.hrm.entity.AccountEntity;
import com.dinethbakers.hrm.entity.BranchEntity;
import com.dinethbakers.hrm.entity.EmployeeEntity;
import com.dinethbakers.hrm.entity.JobRoleEntity;
import com.dinethbakers.hrm.model.Account;
import com.dinethbakers.hrm.model.EmployeeCreate;
import com.dinethbakers.hrm.model.EmployeeRead;
import com.dinethbakers.hrm.repository.jparepository.AccountRepository;
import com.dinethbakers.hrm.repository.jparepository.BranchRepository;
import com.dinethbakers.hrm.repository.jparepository.EmployeeRepository;
import com.dinethbakers.hrm.repository.jparepository.JobRoleRepository;
import com.dinethbakers.hrm.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AccountRepository accountRepository;
    private final BranchRepository branchRepository;
    private final JobRoleRepository jobRoleRepository;
    private final ObjectMapper mapper;
    @Override
    public EmployeeRead persist(EmployeeCreate dto) {
        EmployeeEntity entity = mapper.convertValue(dto, EmployeeEntity.class);

        entity.setEmployeeId(generateId());
        entity.setBranch(getBranchByName(dto.getBranchName()));
        entity.setJobRole(getJobRoleByTitle(dto.getJobRoleTitle()));

        EmployeeEntity savedEntity = employeeRepository.save(entity);

        EmployeeRead savedEmployee = mapper.convertValue(savedEntity, EmployeeRead.class);

        savedEmployee.setAccount(persistAccount(savedEntity.getEmployeeId(), dto.getAccount()));

        return savedEmployee;
    }

    @Override
    public EmployeeRead getById(String id) {
        Optional<EmployeeEntity> byId = employeeRepository.findById(id);

        if (byId.isPresent()){
            return mapper.convertValue(byId, EmployeeRead.class);
        }
        return null;
    }


    private String generateId(){
        String maxId = employeeRepository.findMaxEmployeeId();

        if (maxId == null){
            return "E001";
        }

        String numberPart = maxId.replaceAll("\\D+", "");
        int number = Integer.parseInt(numberPart);
        number++;
        return "E" + String.format("%03d", number);
    }
    private Account persistAccount(String employeeId, Account account){
        Optional<EmployeeEntity> byId = employeeRepository.findById(employeeId);

        AccountEntity accountEntity = mapper.convertValue(account, AccountEntity.class);

        byId.ifPresent(accountEntity::setEmployee);

        return mapper.convertValue(
            accountRepository.save(accountEntity), Account.class
        );
    }
    private BranchEntity getBranchByName(String name){
        Optional<BranchEntity> branchByName = branchRepository.findByName(name);
        return branchByName.orElse(null);
    }

    private JobRoleEntity getJobRoleByTitle(String title){
        Optional<JobRoleEntity> jobRoleByTitle = jobRoleRepository.findByTitle(title);
        return jobRoleByTitle.orElse(null);
    }
}
