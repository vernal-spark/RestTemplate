package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService service;
    @PostMapping("/")
    public ResponseEntity<?> saveDepartment(@RequestBody Department department){
        service.saveDepartment(department);
        return new ResponseEntity<>("Deepartment added", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable int id){
        Department department=service.getDepartmentById(id);
        return new ResponseEntity<Department>(department,HttpStatus.OK);
    }
}
