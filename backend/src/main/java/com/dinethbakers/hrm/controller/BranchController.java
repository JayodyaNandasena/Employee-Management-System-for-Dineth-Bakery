package com.dinethbakers.hrm.controller;

import com.dinethbakers.hrm.model.Branch;
import com.dinethbakers.hrm.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/branch")
@RestController
public class BranchController {
    private final BranchService service;

    @PostMapping
    Branch persist(@RequestBody Branch branch){
        return service.persist(branch);
    }

    @GetMapping("/all")
    List<Branch> getAll(){
        return service.getAll();
    }

    @GetMapping("/by-id")
    Branch getById(@RequestParam(name = "branchId") String id){
        return service.getById(id);
    }

    @GetMapping("/by-name")
    List<Branch> getByName(@RequestParam(name = "branchName") String name){
        return service.getByName(name);
    }

    @GetMapping("/by-location")
    Branch getByLocation(@RequestParam(name = "latitude") BigDecimal latitude,
                         @RequestParam(name = "longitude") BigDecimal longitude){
        return service.getByLocation(latitude, longitude);
    }
    //ERROR

    @PutMapping
    Branch update(@RequestParam(name = "currentBranchId") String id,
                  @RequestBody Branch branch){
        return service.update(id, branch);
    }
    //Trouble

    @DeleteMapping
    Map<String, Boolean> deleteById(@RequestParam(name = "branchId") String id){
        return Collections.singletonMap("Delete status",service.delete(id));
    }

}
