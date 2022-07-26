package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    String Titre;
    @ManyToOne()
    Niveau niveau ;
    @OneToOne(mappedBy = "maFiliere")
    Teacher chefFiliere;
    @OneToMany(mappedBy = "filiere")
    Set<Student>  students=new HashSet<Student>();

}
