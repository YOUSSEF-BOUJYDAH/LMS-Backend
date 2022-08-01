package com.example.demo.ServicesImp;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Niveau;
import com.example.demo.Entities.Student;
import com.example.demo.Repository.FiliereRepository;
import com.example.demo.Repository.NiveauRepository;
import com.example.demo.Services.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class NiveauServiceImp implements NiveauService {
    @Autowired
    private NiveauRepository NR;
    @Autowired
    private FiliereRepository FR;
    @Override
    public Niveau getOne(Long id) {
        return NR.findById(id).get();
    }

    @Override
    public List<Niveau> getAll() {
        return NR.findAll();
    }

    @Override
    public void update(Niveau u) {
            NR.save(u);
    }

    @Override
    public void remove(Niveau s) {
               NR.delete(s);
    }

    @Override
    public Niveau add(Niveau n, Long id) {

        Filiere f=FR.findById(id).get();
        n=NR.save(n);
        f.addNiveau(n);
        FR.save(f);
        return NR.findById(n.getId()).get();
    }
    @Override
    public List<Student> getRejectedStudents(Long id) {
        return this.NR.findById(id).get().getExlcusedStudent();
    }
    @Override
    public List<Student> getDemandeStudents(Long id) {
        return this.NR.findById(id).get().getDemandeStudent();
    }
    @Override
    public List<Student> getAffectedStudents(Long id) {
        return this.NR.findById(id).get().getAffecteStudent();
    }

    public Set<Student> getStudents(Long id) {
        return this.NR.findById(id).get().getStudents();
    }
}
