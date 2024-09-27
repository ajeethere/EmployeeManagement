package com.empManagement.EmpManagement.controllers;

import com.empManagement.EmpManagement.entities.Leave;
import com.empManagement.EmpManagement.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leave")
public class LeavesController {

    @Autowired
    LeaveService leaveService;

    @PostMapping
    public ResponseEntity<?> postLeave(@RequestBody Leave leave) {
        leaveService.addLeave(leave);
        return ResponseEntity.ok("Leave Added!");
    }
    @GetMapping
    public ResponseEntity<?> getAllLeaves() {
        return ResponseEntity.ok(leaveService.getAllLeaves());
    }
}
