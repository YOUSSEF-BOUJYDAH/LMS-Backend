package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    @Column()
    private String username;
    @Column()
    String password;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Role> roles=new HashSet<Role>();

   public void addRole(Role r){
        this.roles.add(r);
    }
    public void removeRole(Role r){
        this.roles.remove(r);
    }
    public void removeRoles(){

    }
}
