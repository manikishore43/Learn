package com.spring.Learn.controller;

import com.spring.Learn.model.student;
import com.spring.Learn.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;


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
        return studentRepository.findById(Id).get();
    }
}


