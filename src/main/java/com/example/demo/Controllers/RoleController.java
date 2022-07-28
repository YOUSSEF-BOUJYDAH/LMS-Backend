package com.example.demo.Controllers;

import com.example.demo.Entities.Role;
import com.example.demo.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Role")
public class RoleController {
    @Autowired
    private RoleRepository RR;
    @GetMapping("/get/{name}")
    Role getName(@PathVariable("name") String name){
        return RR.findByName(name);
    }

}
