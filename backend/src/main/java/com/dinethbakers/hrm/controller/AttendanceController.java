package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.model.Attendance;
import com.dinethbakers.hrm.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping("/clockIn")
    public ResponseEntity<Map<String, Object>> markClockIn(@RequestBody Attendance dto){
        return attendanceService.markClockIn(dto);
    }

    @PostMapping("/clockOut")
    public ResponseEntity<Map<String, Object>> markClockOut(@RequestBody Attendance dto){
        return attendanceService.markClockOut(dto);
//
//        if (attendanceService.markClockOut(dto) != null){
//            return Collections.singletonMap("Status",true);
//        }
//        return Collections.singletonMap("Status",false);
    }
}
