package com.empManagement.EmpManagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "salaries_table")
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String salary;
    private String date;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    Employee employee;

    @JsonProperty("emp_id")
    private Long getEmployeeId() {
        return employee != null ? employee.getId() : null;
    }
}
