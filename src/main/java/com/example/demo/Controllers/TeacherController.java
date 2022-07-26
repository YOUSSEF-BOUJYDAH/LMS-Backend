package com.example.demo.Controllers;

import com.example.demo.Entities.Teacher;
import com.example.demo.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Teacher")
public class TeacherController {
    @Autowired
    private TeacherRepository TR;

    @GetMapping("/get/{id}")
    Optional<Teacher> get(@PathVariable("id") Long id){
        return TR.findById(id);
    }
    @GetMapping("/getAll")
    List<Teacher> getAll(){
        return TR.findAll();
    }
    @PostMapping("/update")
    void update(@RequestBody Teacher u){
        TR.save(u);
    }
    @DeleteMapping("/delete")
    void remove(@RequestBody Teacher s)
    {
        TR.delete(s);
    }
    @PostMapping("/add")
    Teacher add(@RequestBody Teacher s){
        return TR.save(s);
    }

}


