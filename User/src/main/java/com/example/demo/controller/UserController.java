package com.example.demo.controller;

import com.example.demo.model.ResponseTemplateVO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    UserService service;
    @PostMapping("/")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        service.saveUser(user);
        return new ResponseEntity<>("User added", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserWithDepartment(@PathVariable int id){
        ResponseTemplateVO vo=service.getUserWithDepartment(id);
        return new ResponseEntity<ResponseTemplateVO>(vo,HttpStatus.OK);
    }
}
