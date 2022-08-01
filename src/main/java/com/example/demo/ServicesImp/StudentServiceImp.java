package com.example.demo.ServicesImp;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Niveau;
import com.example.demo.Entities.Student;
import com.example.demo.Repository.FiliereRepository;
import com.example.demo.Repository.NiveauRepository;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository SR;
    @Autowired
    private RoleRepository RR;
    @Autowired
    private NiveauRepository NR;
    public Student getOne( Long id){
        return SR.findById(id).get();
    }

    public List<Student> getAll(){
        return SR.findAll();
    }


    public void update( Student u){
        SR.save(u);
    }

    public void remove(Student s)
    {
        SR.delete(s);
    }

    public Student add(Student s, Long id){
        System.out.println(1);
        Niveau f=this.NR.findById(id).get();
        System.out.println(2);
        s.getRoles().add(RR.findByName("student"));
        System.out.println(3);
        Student ss=this.SR.save(s);
        System.out.println(4);
        f.addStudent(ss);
        System.out.println(5);
        this.NR.save(f);
        System.out.println(6);
        return this.SR.findById(ss.getId()).get();
    }

    @Override
    public void setDemanded(Long id) {
        Student s= this.SR.findById(id).get();
        s.setDemanded();
        this.SR.save(s);
    }

    @Override
    public void setAffected(Long id) {
        Student s= this.SR.findById(id).get();
        s.setAffected();
        this.SR.save(s);
    }

    @Override
    public void setrefused(Long id) {
        Student s= this.SR.findById(id).get();
        s.setRefused();
        this.SR.save(s);
    }


}
