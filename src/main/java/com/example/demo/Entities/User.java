package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id ;
    @Column()
    String username;
    @Column()
    String password;
    @ManyToMany(cascade = CascadeType.ALL)
    Set<Role> roles=new HashSet<Role>();
}
