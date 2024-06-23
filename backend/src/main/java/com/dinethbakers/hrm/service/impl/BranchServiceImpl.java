package com.dinethbakers.hrm.service.impl;

import com.dinethbakers.hrm.entity.BranchEntity;
import com.dinethbakers.hrm.model.Branch;
import com.dinethbakers.hrm.repository.jparepository.BranchRepository;
import com.dinethbakers.hrm.repository.nativerepository.BranchNativeRepository;
import com.dinethbakers.hrm.service.BranchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository repository;
    private final BranchNativeRepository nativeRepository;
    private final ObjectMapper mapper;

    @Override
    public Branch persist(Branch branch) {
        BranchEntity savedEntity = repository.save(mapper.convertValue(branch, BranchEntity.class));

        return mapper.convertValue(savedEntity, Branch.class);
    }

    @Override
    public Branch getById(String id) {
        Optional<BranchEntity> byId = repository.findById(id);

        return mapper.convertValue(byId, Branch.class);
    }

    @Override
    public List<Branch> getByName(String name) {
        List<Map<String, Object>> resultList = nativeRepository.findByName(name);

        if (resultList == null){
            return Collections.emptyList();
        }

        List<Branch> branchList = new ArrayList<>();

        resultList.forEach(branchMap -> {
            Branch branch =
                    mapper.convertValue(branchMap, Branch.class);
            branch.setBranchId((Integer) branchMap.get("branch_id"));
            branchList.add(branch);
        });

        return branchList;
    }

    @Override
    public Branch getByLocation(BigDecimal latitude, BigDecimal longitude) {
        Optional<BranchEntity> byLocation = nativeRepository.findByLocation(latitude, longitude);
        return mapper.convertValue(byLocation, Branch.class);
    }

    @Override
    public List<Branch> getAll() {
        Iterable<BranchEntity> branchList = repository.findAll();

        List<Branch> branches = new ArrayList<>();

        branchList.forEach(branchEntity ->
                branches.add(mapper.convertValue(branchEntity, Branch.class)));

        return branches;
    }

    @Override
    public Branch update(String id, Branch branch) {
        Branch byId = getById(id);

        if (byId == null){
            return null;
        }

        BranchEntity savedEntity = repository.save(mapper.convertValue(branch, BranchEntity.class));

        return mapper.convertValue(savedEntity, Branch.class);
    }

    @Override
    public Boolean delete(String id) {
        Optional<BranchEntity> byId = repository.findById(id);

        if (byId.isPresent()){
            repository.delete(mapper.convertValue(byId, BranchEntity.class));
            return true;
        }

        return false;
    }
}