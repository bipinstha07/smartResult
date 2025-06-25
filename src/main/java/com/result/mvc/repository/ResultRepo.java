package com.result.mvc.repository;

import com.result.mvc.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepo extends JpaRepository<Student,Integer> {

    public Student findByRollNumber(String rollNumber);
}
