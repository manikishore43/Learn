package com.spring.Learn.controller;

import com.spring.Learn.model.student;
import com.spring.Learn.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Validated
@RestController
@RequestMapping("v1/student")
public class StudentController {

    @Autowired
    StudentService service;

    @Autowired
    WebClient.Builder webClientBuilder;

    @PostMapping("/saveStudent")
    public student saveStudent(@RequestBody @Valid student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/getAllStudents")
    public List<student> getStudent()
    {
       return service.getAllStudents();
    }

    @GetMapping("/getStudentById/{Id}")
    public student getStudentById(@PathVariable Long Id)
    {
      return service.getStudentById(Id);
    }

    @GetMapping("/health")
    public String getHealth(){
        return "Hello";
    }

    @PutMapping("/upDateStudent")
    public student upDate(@RequestBody @Valid student student) {
        return service.upDateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") Long Id) {
        service.deleteStudent(Id);
    }

}


