package com.empManagement.EmpManagement.controllers;

import com.empManagement.EmpManagement.entities.Employee;
import com.empManagement.EmpManagement.entities.Salary;
import com.empManagement.EmpManagement.services.EmployeeService;
import com.empManagement.EmpManagement.services.SalaryService;
import com.empManagement.EmpManagement.tdos.TdoEmpSalary;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    SalaryService salaryService;
    @Autowired
    EmployeeService employeeService;

    @Transactional
    @PostMapping
    public ResponseEntity<?> postSalary(@RequestBody TdoEmpSalary tdoEmpSalary) {
        Optional<Employee> employee=employeeService.getEmployeeById(tdoEmpSalary.getEmpId());
        if (employee.isPresent()) {
            Salary salary=new Salary();
            salary.setSalary(tdoEmpSalary.getSalary());
            salary.setDate(tdoEmpSalary.getDate());
            salary.setEmployee(employee.get());
            salary.setIncreaseDecreaseSalary(tdoEmpSalary.getSalary()-employee.get().getSalary());
            if(tdoEmpSalary.getSalary()-employee.get().getSalary()!=0) {
                employeeService.updateEmployeeSalary(employee.get().getId(), tdoEmpSalary.getSalary());
            }
            salaryService.addSalary(salary);
            return ResponseEntity.ok("Salary added successfully");
        }else{
            return new ResponseEntity<>("Employee not found!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Salary> getAllSalary() {
        return salaryService.getAllSalary();
    }

}
