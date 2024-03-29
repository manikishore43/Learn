package com.spring.Learn.controller;

import com.spring.Learn.model.student;
import com.spring.Learn.repo.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.spring.Learn.model.Address;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Validated
@RestController
@RequestMapping("v1/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @PostMapping("/saveStudent")
    public student saveStudent(@RequestBody @Valid student student)
    {
        return studentRepository.save(student);
    }

    @GetMapping("/getAllStudents")
    public List<student> getStudent()
    {
        List<student> studentList= studentRepository.findAll();
        studentList.forEach(
                student -> {
                    Address a = webClientBuilder.build().get().uri("http://localhost:8081/v1/address/getAddressByName/"+ student.getName()).retrieve().bodyToMono(Address.class).block();
                    student.setAddress(a);
                }
        );
        return studentList;
    }

    @GetMapping("/getStudentById/{Id}")
    public student getStudentById(@PathVariable Long Id)
    {
        student s= studentRepository.findById(Id).get();
        Address a= webClientBuilder.build().get().uri("http://localhost:8081/v1/address/getAddressByName/"+s.getName()).retrieve().bodyToMono(Address.class).block();
        s.setAddress(a);
        return s;
    }
}


