package com.example.demo.ServicesImp;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Teacher;
import com.example.demo.Services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService {

    @Override
    public Teacher getOne(Long id) {
        return null;
    }

    @Override
    public List<Filiere> getAll() {
        return null;
    }

    @Override
    public void update(Filiere u) {

    }

    @Override
    public void remove(Filiere s) {

    }

    @Override
    public Filiere add(Filiere f, Long id) {
        return null;
    }
}
