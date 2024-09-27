package com.empManagement.EmpManagement.repositories;

import com.empManagement.EmpManagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
