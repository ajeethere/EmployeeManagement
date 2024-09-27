package com.empManagement.EmpManagement.services;

import com.empManagement.EmpManagement.entities.Leave;
import com.empManagement.EmpManagement.repositories.LeavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeaveService {
    @Autowired
    LeavesRepository leavesRepo;

    public void addLeave(Leave leave) {
        leavesRepo.save(leave);
    }

    public List<Leave> getAllLeaves() {
        return leavesRepo.findAll();
    }

}
