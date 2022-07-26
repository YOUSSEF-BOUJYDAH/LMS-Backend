package com.example.demo.Controllers;

import com.example.demo.Entities.Filiere;
import com.example.demo.Entities.Student;
import com.example.demo.Repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Filiere")
public class FiliereController {
    @Autowired
    private FiliereRepository FR;
    @GetMapping("/get/{id}")
    Optional<Filiere> get(@PathVariable("id") Long id){
         return FR.findById(id);
    }
    @GetMapping("/getAll")
    List<Filiere> getAll(){
        return FR.findAll();
    }
    @PutMapping("/update")
    void update(@RequestBody Filiere u){
        FR.save(u);
    }
    @DeleteMapping("/delete")
    void remove(@RequestBody Filiere s)
    {
        FR.delete(s);
    }
    @PostMapping("/add")
    Filiere add(@RequestBody Filiere s){
        return FR.save(s);
    }

}


