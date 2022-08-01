package com.example.demo.Controllers;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Niveau;
import com.example.demo.Entities.Student;
import com.example.demo.Repository.FiliereRepository;
import com.example.demo.Repository.NiveauRepository;
import com.example.demo.ServicesImp.FiliereServiceImp;
import com.example.demo.ServicesImp.NiveauServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Niveau")
public class NiveauController {
    @Autowired
    private NiveauServiceImp NS;
    @GetMapping("/get/{id}")
    Niveau get(@PathVariable("id") Long id){
        return NS.getOne(id);
    }
    @GetMapping("/getAll")
    List<Niveau> getAll(){
        return NS.getAll();
    }
    @PutMapping("/update")
    void update(@RequestBody Niveau u){
        NS.update(u);
    }
    @DeleteMapping("/delete")
    void remove(@RequestBody Niveau s)
    {
        NS.remove(s);
    }
    @PostMapping("/add/{id}")
    Niveau add(@RequestBody Niveau s,@PathVariable("id") Long id){
        return NS.add(s,id);
    }
    @GetMapping("/get/{id}/Students")
    Set<Student> getStudents(@PathVariable("id") Long id){
        return NS.getStudents(id);
    }
    @GetMapping("/get/{id}/Demanded")
    List<Student> getDemanded(@PathVariable("id") Long id){
        return NS.getDemandeStudents(id);
    }
    @GetMapping("/get/{id}/Affected")
    List<Student> getAffected(@PathVariable("id") Long id){
        return NS.getAffectedStudents(id);
    }
    @GetMapping("/get/{id}/Refused")
    List<Student> getRefused(@PathVariable("id") Long id){
        return NS.getRejectedStudents(id);
    }
}

