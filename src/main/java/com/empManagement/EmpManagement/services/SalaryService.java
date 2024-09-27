package com.empManagement.EmpManagement.services;

import com.empManagement.EmpManagement.entities.Salary;
import com.empManagement.EmpManagement.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    public void addSalary(Salary salary) {
        salaryRepository.save(salary);
    }
    public List<Salary> getAllSalary() {
        return salaryRepository.findAll();
    }

}
