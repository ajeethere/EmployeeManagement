package com.empManagement.EmpManagement.services;

import com.empManagement.EmpManagement.entities.Employee;
import com.empManagement.EmpManagement.entities.Team;
import com.empManagement.EmpManagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public void addMemberInTeam(Team team, Long employeeId) {
        employeeRepository.addToATeam(team,employeeId);
    }
    public void updateEmployeeSalary(Long id, Double salary) {
        employeeRepository.updateSalary(salary, id);
    }
}
