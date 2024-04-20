package com.spring.Learn.service;

import com.spring.Learn.model.Address;
import com.spring.Learn.model.student;
import com.spring.Learn.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    @Autowired
    WebClient.Builder webClientBuilder;

    public student saveStudent(student student){
        return repository.save(student);
    }

    public List<student> getAllStudents(){
        List<student> studentList= repository.findAll();
        studentList.forEach(
                student -> {
                    Address a = webClientBuilder.build().get().uri("http://localhost:8081/v1/address/getAddressByName/"+ student.getName()).retrieve().bodyToMono(Address.class).block();
                    student.setAddress(a);
                }
        );
        return studentList;
    }

    public student getStudentById(Long Id){
        student s= repository.findById(Id).get();
        Address a= webClientBuilder.build().get().uri("http://localhost:8081/v1/address/getAddressByName/"+s.getName()).retrieve().bodyToMono(Address.class).block();
        s.setAddress(a);
        return s;
    }

    public student getStudentByIdOnly(Long Id){
        student s= repository.findById(Id).get();
      //  Address a= webClientBuilder.build().get().uri("http://localhost:8081/v1/address/getAddressByName/"+s.getName()).retrieve().bodyToMono(Address.class).block();
      //  s.setAddress(a);
        return s;
    }

    public student upDateStudent(student student){
        return repository.save(student);
    }

    public void deleteStudent(Long Id){
        Optional<student> s= repository.findById(Id);
        repository.delete(s.get());
    }
}
