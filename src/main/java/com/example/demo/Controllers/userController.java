package com.example.demo.Controllers;

import com.example.demo.Entities.User;
import com.example.demo.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class userController {
    @Autowired
    private userRepository UR;
    @PostMapping("/login")
    User login(@RequestBody User u){
        return UR.findByUsernameAndPassword(u.getUsername(),u.getPassword());
    }
}
