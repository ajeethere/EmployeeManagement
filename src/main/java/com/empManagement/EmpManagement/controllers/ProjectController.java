package com.empManagement.EmpManagement.controllers;

import com.empManagement.EmpManagement.entities.Project;
import com.empManagement.EmpManagement.services.EmployeeService;
import com.empManagement.EmpManagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> addProject(@RequestBody Project project) {
        projectService.addProject(project);
        return ResponseEntity.ok("Project added successfully!");
    }

    @GetMapping
    public ResponseEntity<?> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }
}
