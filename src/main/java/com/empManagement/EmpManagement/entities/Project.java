package com.empManagement.EmpManagement.entities;

import com.empManagement.EmpManagement.tdos.TdoEmpProject;
import com.empManagement.EmpManagement.tdos.TdoIdName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "projects")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    private List<Employee> employees = new ArrayList<Employee>();

    @JsonProperty("project_employees")
    public List<TdoIdName> getEmployeesNames() {
        return employees.stream()
                .map(emp -> {
                    TdoIdName tdoIdName = new TdoIdName();
                    tdoIdName.setName(emp.getName());
                    tdoIdName.setId(emp.getId());
                    return tdoIdName;
                })
                .collect(Collectors.toList());
    }
}
