package com.empManagement.EmpManagement.services;

import com.empManagement.EmpManagement.entities.Employee;
import com.empManagement.EmpManagement.entities.Project;
import com.empManagement.EmpManagement.entities.Team;
import com.empManagement.EmpManagement.repositories.EmployeeRepository;
import com.empManagement.EmpManagement.repositories.ProjectRepository;
import com.empManagement.EmpManagement.tdos.TdoEmpProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void addMemberInTeam(Team team, Long employeeId) {
        employeeRepository.addToATeam(team,employeeId);
    }
    public void updateEmployeeSalary(Long id, Double salary) {
        employeeRepository.updateSalary(salary, id);
    }

    public void addToProject(TdoEmpProject tdoEmpProject) {
        Employee employee=employeeRepository.findById(tdoEmpProject.getEmpId()).orElseThrow(()->new RuntimeException("Employee not found!"));
        Project project=projectRepository.findById(tdoEmpProject.getProjectId()).orElseThrow(()->new RuntimeException("Project not found!"));
        employee.getProjects().add(project);
        project.getEmployees().add(employee);
        employeeRepository.save(employee);
    }
}
