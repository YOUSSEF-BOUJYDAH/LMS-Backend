package com.example.demo.Controllers;

import com.example.demo.Entities.UserAdmin;
import com.example.demo.Repository.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/UserAdmin")
public class UserAdminController {
    @Autowired
    private UserAdminRepository AR;

    @GetMapping("/get/{id}")
    Optional<UserAdmin> get(@PathVariable("id") Long id){
        return AR.findById(id);
    }
    @GetMapping("/getAll")
    List<UserAdmin> get(){
        return AR.findAll();
    }
    @PutMapping("/update")
    void update(@RequestBody UserAdmin u){
        AR.save(u);
    }
    @DeleteMapping("/delete")
    void remove(@RequestBody UserAdmin s)
    {
        AR.delete(s);
    }
    @PostMapping("/add")
    UserAdmin add(@RequestBody UserAdmin s){
        return AR.save(s);
    }
}
