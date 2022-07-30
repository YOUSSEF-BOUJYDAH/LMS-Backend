package com.example.demo.Services;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Niveau;
import com.example.demo.Entities.Role;
import com.example.demo.Entities.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Teacher getOne(Long id);
    List<Filiere> getAll();
    void update(Filiere u);
    void remove(Filiere s);
    Filiere add(Filiere f ,Long id);
    }


