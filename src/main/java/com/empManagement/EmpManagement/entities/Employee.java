package com.empManagement.EmpManagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee_table")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Double salary;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Leave> leaves = new ArrayList<>();
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Salary> salaries = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "employee_table_projects", // name of the join table
            joinColumns = @JoinColumn(name = "employees_id"), // FK to Employee
            inverseJoinColumns = @JoinColumn(name = "projects_id") // FK to Project
    )
    private List<Project> projects = new ArrayList<>();

    @JsonProperty("team")
    private String getTeam() {
        return team!=null?team.getTeamName():null;
    }

}
