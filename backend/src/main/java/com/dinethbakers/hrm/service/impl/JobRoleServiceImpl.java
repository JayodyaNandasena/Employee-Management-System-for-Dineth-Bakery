package com.dinethbakers.hrm.service.impl;

import com.dinethbakers.hrm.entity.*;
import com.dinethbakers.hrm.model.*;
import com.dinethbakers.hrm.repository.jparepository.*;
import com.dinethbakers.hrm.service.JobRoleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JobRoleServiceImpl implements JobRoleService {
    private final JobRoleRepository jobRoleRepository;
    private final SalaryPolicyRepository salaryPolicyRepository;
    private final LeavePolicyRepository leavePolicyRepository;
    private final ShiftPolicyRepository shiftPolicyRepository;

    private final ObjectMapper mapper;


    @Override
    public JobRole persist(JobRole dto) {

        JobRoleEntity jobRoleEntity = mapper.convertValue(dto, JobRoleEntity.class);
        jobRoleEntity.setSalaryPolicy(
                findOrCreateSalaryPolicy(dto.getSalaryPolicy()));
        jobRoleEntity.setLeavePolicy(
                findOrCreateLeavePolicy(dto.getLeavePolicy()));
        jobRoleEntity.setShiftPolicies(
                findOrCreateShiftPolicies(dto.getShiftPolicies()));

        return mapper.convertValue(
                jobRoleRepository.save(jobRoleEntity), JobRole.class) ;
    }


    private SalaryPolicyEntity findOrCreateSalaryPolicy(SalaryPolicy dto){
        SalaryPolicyEntity byAll =
                salaryPolicyRepository.
                        findByMonthlyBasicSalaryAndOvertimeSalaryPerHourAndEpfPercentageAndEtfPercentage(
                                dto.getMonthlyBasicSalary(),
                                dto.getOvertimeSalaryPerHour(),
                                dto.getEpfPercentage(),
                                dto.getEtfPercentage()
                        ).orElse(null);

        if (byAll != null){
            return byAll;
        }
        return salaryPolicyRepository.save(
                mapper.convertValue(dto, SalaryPolicyEntity.class));

    }

    private LeavePolicyEntity findOrCreateLeavePolicy(LeavePolicy dto){
        LeavePolicyEntity byAll = leavePolicyRepository.findByNoOfPTODays(
                dto.getNoOfPTODays())
                .orElse(null);

        if (byAll != null){
            return byAll;
        }

        return leavePolicyRepository.save(
                mapper.convertValue(dto, LeavePolicyEntity.class));

    }


    private List<ShiftPolicyEntity> findOrCreateShiftPolicies(
            List<ShiftPolicy> dtos){

        List<ShiftPolicyEntity> policyEntityList = new ArrayList<>();

        for (ShiftPolicy policy: dtos) {
            ShiftPolicyEntity byAll = shiftPolicyRepository.findByStartTimeAndEndTime(
                    policy.getStartTime(),
                    policy.getEndTime())
                    .orElse(null);

            if (byAll != null){
                policyEntityList.add(byAll);
            }else {
                policyEntityList.add(
                        shiftPolicyRepository.save(
                            mapper.convertValue(policy, ShiftPolicyEntity.class))
                );
            }
        }

        return policyEntityList;
    }
}
