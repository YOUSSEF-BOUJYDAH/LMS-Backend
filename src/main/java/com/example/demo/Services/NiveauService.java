package com.example.demo.Services;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Niveau;
import com.example.demo.Entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface NiveauService {
    Niveau getOne(Long id);
    List<Niveau> getAll();
    void update(Niveau u);
    void remove(Niveau s);
    Niveau add(Niveau f ,Long id);
    Set<Student> getStudents(Long id);
    List<Student> getRejectedStudents(Long id);
    List<Student> getDemandeStudents(Long id);
    List<Student> getAffectedStudents(Long id);
}
