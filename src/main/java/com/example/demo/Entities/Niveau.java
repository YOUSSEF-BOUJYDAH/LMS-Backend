package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
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

    void addFiliere(Filiere f){
        f.setNiveau(this);
        this.Filieres.add(f);
    }
    void removeFiliere(Filiere f){
        f.setNiveau(null);
        this.Filieres.remove(f);
    }
    void removeFilieres(){
        Iterator<Filiere> iterator = this.Filieres.iterator();
        while (iterator.hasNext()) {
            Filiere f = iterator.next();
            f.setNiveau(null);
            iterator.remove();
        }
    }
}
