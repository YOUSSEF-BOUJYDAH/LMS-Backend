package com.example.demo.Repository;

import com.example.demo.Entities.Student;
import com.example.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByUsernameAndPassword(String username , String password);
}
