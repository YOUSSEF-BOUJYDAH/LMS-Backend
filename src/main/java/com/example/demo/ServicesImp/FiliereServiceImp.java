package com.example.demo.ServicesImp;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Niveau;
import com.example.demo.Entities.Student;
import com.example.demo.Repository.FiliereRepository;
import com.example.demo.Repository.NiveauRepository;
import com.example.demo.Services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@Service
public class FiliereServiceImp implements FiliereService {
    @Autowired
    private FiliereRepository FR;
    @Autowired
    private NiveauRepository NR;
    public Filiere getOne(Long id){
        return FR.findById(id).get();
    }
    public List<Filiere> getAll(){
        return FR.findAll();
    }
    public void update( Filiere u){
        FR.save(u);
    }
    public void remove(Filiere s)
    {
        FR.delete(s);
    }
    public Filiere add( Filiere f,Long id){
        Niveau n=NR.findById(id).get();
        Filiere filiere=FR.save(f);
        System.out.println("  "+filiere.getId());
        n.addFiliere(filiere);
        NR.save(n);
        return FR.findById(filiere.getId()).get();
    }

    @Override
    public List<Student> getRejectedStudents(Long id) {
        return this.FR.findById(id).get().getExlcusedStudent();
    }
    @Override
    public List<Student> getDemandeStudents(Long id) {
        return this.FR.findById(id).get().getDemandeStudent();
    }
    @Override
    public List<Student> getAffectedStudents(Long id) {
        return this.FR.findById(id).get().getAffecteStudent();
    }

    public Set<Student> getStudents(Long id) {
        return this.FR.findById(id).get().getStudents();
    }
}
