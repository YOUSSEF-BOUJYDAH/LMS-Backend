package com.example.demo.Controllers;


import com.example.demo.Entities.Student;
import com.example.demo.Entities.User;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentRepository SR;
    @GetMapping("/get/{id}")
    Optional<Student> get(@PathVariable("id")Long id){
        return SR.findById(id);
    }
    @GetMapping("/getAll")
    List<Student> getAll(){
        return SR.findAll();
    }

    @PutMapping("/update")
    void update(@RequestBody Student u){
        SR.save(u);
    }
    @DeleteMapping("/delete")
    void remove(@RequestBody Student s)
    {
        SR.delete(s);
    }
    @PostMapping("/add")
    Student add(@RequestBody Student s){
        return SR.save(s);
    }

}