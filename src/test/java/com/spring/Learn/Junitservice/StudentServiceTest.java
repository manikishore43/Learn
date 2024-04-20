package com.spring.Learn.Junitservice;

import com.spring.Learn.model.student;
import com.spring.Learn.repo.StudentRepository;
import com.spring.Learn.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;


    @Test
    void getStudentByIdTest() {

        Mockito.when(studentRepository.findById(1l)).thenReturn(createStudent());
        student s=studentService.getStudentByIdOnly(1L);
        assertEquals(s.getName(),"mani");
    }

    private Optional<student> createStudent(){
        student s= student.builder().id(1L).name("mani").build();
        return Optional.ofNullable(s);
    }
}