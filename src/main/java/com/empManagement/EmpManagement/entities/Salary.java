package com.empManagement.EmpManagement.entities;

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
}
