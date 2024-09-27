package com.empManagement.EmpManagement.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "leaves_table")
@Data
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
}
