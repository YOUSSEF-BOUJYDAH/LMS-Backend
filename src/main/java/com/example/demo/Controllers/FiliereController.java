package com.example.demo.Controllers;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Niveau;
import com.example.demo.Entities.Student;
import com.example.demo.Repository.FiliereRepository;
import com.example.demo.Repository.NiveauRepository;
import com.example.demo.ServicesImp.FiliereServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Filiere")
public class FiliereController {

    @Autowired
    private FiliereServiceImp FS;
    @GetMapping("/get/{id}")
    Filiere get(@PathVariable("id") Long id){
         return FS.getOne(id);
    }
    @GetMapping("/getAll")
    List<Filiere> getAll(){
        return FS.getAll();
    }
    @PutMapping("/update")
    void update(@RequestBody Filiere u){
        FS.update(u);
    }
    @DeleteMapping("/delete")
    void remove(@RequestBody Filiere s)
    {
        FS.remove(s);
    }
    @PostMapping("/add")
    Filiere add(@RequestBody Filiere f){
        return FS.add(f);
    }
    @GetMapping("/get/{id}/Niveaux")
    Set<Niveau> getNiveaux(@PathVariable("id") Long id){
        return FS.getNiveaux(id);
    }
}


