package com.empManagement.EmpManagement.services;

import com.empManagement.EmpManagement.entities.Project;
import com.empManagement.EmpManagement.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public void addProject(Project project) {
        projectRepository.save(project);
    }
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }
}
