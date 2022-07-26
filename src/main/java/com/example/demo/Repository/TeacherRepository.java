package com.example.demo.Repository;

import com.example.demo.Entities.Teacher;
import com.example.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Teacher findByUsernameAndPassword(String username , String password);
}
