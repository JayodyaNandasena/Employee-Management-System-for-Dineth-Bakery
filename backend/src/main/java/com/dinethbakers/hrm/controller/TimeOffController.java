package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.model.TimeOffApproval;
import com.dinethbakers.hrm.model.TimeOffRequest;
import com.dinethbakers.hrm.model.TimeOffRequestRead;
import com.dinethbakers.hrm.service.TimeOffService;
import com.dinethbakers.hrm.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/timeOff")
public class TimeOffController {
    private final TimeOffService timeOffService;

    @GetMapping
    public List<TimeOffRequestRead> getAll(@RequestParam Status status){
        return timeOffService.getAll(status);
    }

    @GetMapping("/byId")
    public List<TimeOffRequestRead> getById(@RequestParam String requestId){
        return timeOffService.getById(requestId);
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> persistRequest(@RequestBody TimeOffRequest dto){
        return timeOffService.persistRequest(dto);
    }

    @PutMapping()
    public ResponseEntity<Map<String, Object>> manageRequest(@RequestBody TimeOffApproval dto){
        return timeOffService.manageRequest(dto);
    }
}
