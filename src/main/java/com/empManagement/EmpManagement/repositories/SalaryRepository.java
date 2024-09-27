package com.empManagement.EmpManagement.repositories;

import com.empManagement.EmpManagement.entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
