package com.empManagement.EmpManagement.services;

import com.empManagement.EmpManagement.entities.Employee;
import com.empManagement.EmpManagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
