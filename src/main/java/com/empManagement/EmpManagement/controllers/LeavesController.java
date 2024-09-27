package com.empManagement.EmpManagement.controllers;

import com.empManagement.EmpManagement.entities.Employee;
import com.empManagement.EmpManagement.entities.Leave;
import com.empManagement.EmpManagement.services.EmployeeService;
import com.empManagement.EmpManagement.services.LeaveService;
import com.empManagement.EmpManagement.tdos.TdoEmpLeaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/leave")
public class LeavesController {

    @Autowired
    LeaveService leaveService;

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> postLeave(@RequestBody TdoEmpLeaves tdoEmpLeaves) {
        Optional<Employee> employee = employeeService.getEmployeeById(tdoEmpLeaves.getEmpId());
        if (employee.isPresent()) {
            Leave leave = new Leave();
            leave.setEmployee(employee.get());
            leave.setDate(tdoEmpLeaves.getDate());
            leaveService.addLeave(leave);
            return ResponseEntity.ok("Leave Added!");
        } else {
            return new ResponseEntity<>("Employee not found!", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public ResponseEntity<?> getAllLeaves() {
        return ResponseEntity.ok(leaveService.getAllLeaves());
    }
}
