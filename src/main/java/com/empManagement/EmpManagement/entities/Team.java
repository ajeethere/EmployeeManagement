package com.empManagement.EmpManagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "teams")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;
    private String teamName;
    private String teamDescription;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Employee> employees=new ArrayList<>();


    @JsonProperty("employees")
    public List<String> getEmployees() {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }
}
