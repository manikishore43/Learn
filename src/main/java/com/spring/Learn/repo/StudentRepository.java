package com.spring.Learn.repo;

import com.spring.Learn.model.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<student,Long> {
}
