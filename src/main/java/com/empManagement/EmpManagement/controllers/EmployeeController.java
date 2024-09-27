package com.empManagement.EmpManagement.controllers;

import com.empManagement.EmpManagement.entities.Employee;
import com.empManagement.EmpManagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> postEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.ok("Employee added successfully!");
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
     return ResponseEntity.ok(employeeService.getEmployees());
    }
}
