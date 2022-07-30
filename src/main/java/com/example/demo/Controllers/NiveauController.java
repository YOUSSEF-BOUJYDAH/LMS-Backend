package com.example.demo.Controllers;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Niveau;
import com.example.demo.Repository.FiliereRepository;
import com.example.demo.Repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Niveau")
public class NiveauController {
    @Autowired
    private NiveauRepository NR;
    @Autowired
    FiliereRepository FR;
    @GetMapping("/get/{id}")
    Optional<Niveau> get(@PathVariable("id") Long id){
        return NR.findById(id);
    }
    @GetMapping("/getAll")
    List<Niveau> getAll(){
        return NR.findAll();
    }
    @PutMapping("/update")
    void update(@RequestBody Niveau u){
        NR.save(u);
    }
    @DeleteMapping("/delete")
    void remove(@RequestBody Niveau s)
    {
        NR.delete(s);
    }
    @PostMapping("/add")
    Niveau add(@RequestBody Niveau s){
        return NR.save(s);
    }

}

