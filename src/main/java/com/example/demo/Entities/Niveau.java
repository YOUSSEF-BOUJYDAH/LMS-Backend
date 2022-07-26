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
public class Niveau {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    String Titre;
    @OneToMany(mappedBy = "niveau" )
    Set<Filiere> Filieres =new HashSet<Filiere>();
}
