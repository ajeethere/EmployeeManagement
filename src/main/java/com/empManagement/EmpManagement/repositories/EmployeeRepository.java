package com.empManagement.EmpManagement.repositories;

import com.empManagement.EmpManagement.entities.Employee;
import com.empManagement.EmpManagement.entities.Team;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.salary = :salary WHERE e.id = :id")
    void updateSalary(@Param("salary") Double salary, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.team = :team WHERE e.id = :id")
    void addToATeam(@Param("team") Team team, @Param("id") Long id);
}
