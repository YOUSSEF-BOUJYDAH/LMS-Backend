package com.example.demo.Services;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Student;

import java.util.List;
import java.util.Set;

public interface FiliereService {
    Filiere getOne(Long id);
    List<Filiere> getAll();
    void update(Filiere u);
    void remove(Filiere s);
    Filiere add(Filiere f ,Long id);

    List<Student> getRejectedStudents( Long id);
    List<Student> getDemandeStudents(Long id);
    List<Student> getAffectedStudents(Long id);
}
