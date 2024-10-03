package com.empManagement.EmpManagement.controllers;

import com.empManagement.EmpManagement.entities.Employee;
import com.empManagement.EmpManagement.entities.Project;
import com.empManagement.EmpManagement.entities.Team;
import com.empManagement.EmpManagement.services.EmployeeService;
import com.empManagement.EmpManagement.services.ProjectService;
import com.empManagement.EmpManagement.services.TeamService;
import com.empManagement.EmpManagement.tdos.TdoAddToTeam;
import com.empManagement.EmpManagement.tdos.TdoEmpProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    TeamService teamService;

    @Autowired
    ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> postEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.ok("Employee added successfully!");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully!");
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
     return ResponseEntity.ok(employeeService.getEmployees());
    }
    @PutMapping
    public ResponseEntity<?> addInTeam(@RequestBody TdoAddToTeam tdoAddToTeam) {
        Optional<Team> team=teamService.getTeamById(tdoAddToTeam.getTeamId());
        if(team.isPresent()) {
            employeeService.addMemberInTeam(team.get(), tdoAddToTeam.getEmpId());
            return ResponseEntity.ok("Employee updated successfully!");
        }else {
            return ResponseEntity.ok("Team not found!");
        }
    }
    @PutMapping("/project")
    public ResponseEntity<?> addProjectInTeam(@RequestBody TdoEmpProject tdoEmpProject) {
       employeeService.addToProject(tdoEmpProject);
       return ResponseEntity.ok("Employee updated successfully!");
    }
}
