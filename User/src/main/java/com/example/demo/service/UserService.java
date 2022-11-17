package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.ResponseTemplateVO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final Logger logger= LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository repo;
    @Autowired
    RestTemplate restTemplate;
    public void saveUser(User user) {
        repo.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(int id) {
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user=repo.findById(id).get();
        logger.info(user.toString());
        Department department=restTemplate.getForObject("http://localhost:8080/departments/"+user.getDid(),Department.class);
        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
