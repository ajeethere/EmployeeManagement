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

    @JsonProperty("team")
    private String getTeam() {
        return team!=null?team.getTeamName():null;
    }

}
