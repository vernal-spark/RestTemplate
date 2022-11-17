package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository repo;
    public void saveDepartment(Department department) {
        repo.save(department);
    }

    public Department getDepartmentById(int id) {
        Department department=repo.findById(id).get();
        return department;
    }
}
