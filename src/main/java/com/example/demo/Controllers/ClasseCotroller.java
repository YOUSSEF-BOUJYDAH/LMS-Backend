package com.example.demo.Controllers;

import com.example.demo.Entities.Classe;
import com.example.demo.Repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClasseCotroller {
    @Autowired
    private ClasseRepository CR;
    @GetMapping("/classes")//this.http.get<Classe[]>(this.baseUrl + "/classes");
    List<Classe> getAll(){
        return CR.findAll();
    }
    @GetMapping("/classes/{id}")//this.http.get<Classe>(this.baseUrl+"/classes/"+id)
    Optional<Classe> getClasse(@PathVariable("id") Long id){
        return CR.findById(id);
    }
    @PostMapping("/add")//this.http.post<Classe>(this.baseUrl + "/add", classe);
    void addClasse(@RequestBody Classe classe)
     {
        this.CR.save(classe);
     }
     @DeleteMapping("/delete/{id}")//this.http.delete(this.baseUrl+"/delete/"+id);
     void deleteClasse(@PathVariable("id") Long id){

        CR.deleteById(id);
    }
     @PutMapping("/update")//this.http.put<Classe>(this.baseUrl+"/update",c);
     void update(@RequestBody Classe c){
        CR.save(c);
     }
}
