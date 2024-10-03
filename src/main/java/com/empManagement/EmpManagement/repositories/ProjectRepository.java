package com.empManagement.EmpManagement.repositories;

import com.empManagement.EmpManagement.entities.Employee;
import com.empManagement.EmpManagement.entities.Project;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Project p SET p.employees = :employees WHERE p.id = :id")
    void updateEmployees(Long id, Employee employees);
}
