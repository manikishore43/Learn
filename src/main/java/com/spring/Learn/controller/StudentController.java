package com.spring.Learn.controller;

import com.spring.Learn.model.student;
import com.spring.Learn.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.spring.Learn.model.Address;

import java.util.List;

@RestController
@RequestMapping("v1/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RestTemplate restTemplate;


    @PostMapping("/saveStudent")
    public student saveStudent(@RequestBody student student)
    {
        return studentRepository.save(student);
    }

    @GetMapping("/getAllStudents")
    public List<student> getStudent()
    {
        return studentRepository.findAll();
    }

    @GetMapping("/getStudentById/{Id}")
    public student getStudentById(@PathVariable Long Id)
    {
        student s= studentRepository.findById(Id).get();
        System.out.println(s.getName() + " Name");
        Address a = restTemplate.getForObject(
                "http://localhost:8081/v1/address/getAddressByName/{name}", Address.class, s.getName());
        s.setAddress(a);
        return s;
    }
}


