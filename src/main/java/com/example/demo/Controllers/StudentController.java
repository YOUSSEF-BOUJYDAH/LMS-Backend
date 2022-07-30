package com.example.demo.Controllers;


import com.example.demo.Entities.Student;
import com.example.demo.Entities.User;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Services.StudentService;
import com.example.demo.ServicesImp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentServiceImp SS;
    @GetMapping("/get/{id}")
    Student get(@PathVariable("id")Long id){
        return SS.getOne(id);
    }
    @GetMapping("/getAll")
    List<Student> getAll(){
        return SS.getAll();
    }
    @PutMapping("/update")
    void update(@RequestBody Student u){
        SS.update(u);
    }
    @DeleteMapping("/delete")
    void remove(@RequestBody Student s)
    {
        SS.remove(s);
    }
    @PostMapping("/add/{id}")
    Student add(@RequestBody Student s,@PathVariable("id")Long id){
        return SS.add(s,id);
    }
    @PutMapping("/setDemande/{id}")
    void setDemande(@PathVariable("id")Long id){
        SS.setDemande(id);
    }
    @PutMapping("/setAffected/{id}")
    void setAffected(@PathVariable("id")Long id){
        SS.setAffected(id);
    }
    @PutMapping("/setRefused/{id}")
    void setRefused(@PathVariable("id")Long id){
        SS.setrefused(id);
    }
}