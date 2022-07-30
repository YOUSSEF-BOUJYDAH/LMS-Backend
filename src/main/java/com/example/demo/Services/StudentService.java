package com.example.demo.Services;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Student;
import com.example.demo.Entities.Teacher;

import java.util.List;

public interface StudentService {
    Student getOne(Long id);
    List<Student> getAll();
    void update(Student u);
    void remove(Student s);
    Student add(Student f ,Long id);
    void setDemande(Long id);
    void setAffected(Long id);
    void setrefused(Long id);
}
