package com.empManagement.EmpManagement.repositories;

import com.empManagement.EmpManagement.entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavesRepository extends JpaRepository<Leave, Long> {
}
