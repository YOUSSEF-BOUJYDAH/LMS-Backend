package com.example.demo.ServicesImp;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Niveau;
import com.example.demo.Entities.Student;
import com.example.demo.Repository.FiliereRepository;
import com.example.demo.Repository.NiveauRepository;
import com.example.demo.Services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class FiliereServiceImp implements FiliereService {
    @Autowired
    private FiliereRepository FR;

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
    public Filiere add( Filiere f){
        return FR.save(f);
    }

    @Override
    public Set<Niveau> getNiveaux(Long id) {
        return this.FR.findById(id).get().getNiveaux();
    }


}
