package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Niveau implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Titre;
    private String diplome;
    @OneToMany(mappedBy = "niveau" ,cascade = CascadeType.ALL)
            @JsonIgnore
    Set<Filiere> Filieres =new HashSet<Filiere>();

    public void addFiliere(Filiere f){
        f.setNiveau(this);
        this.Filieres.add(f);
    }
    public void removeFiliere(Filiere f){
        f.setNiveau(null);
        this.Filieres.remove(f);
    }
    public void removeFilieres(){
        Iterator<Filiere> iterator = this.Filieres.iterator();
        while (iterator.hasNext()) {
            Filiere f = iterator.next();
            f.setNiveau(null);
            iterator.remove();
        }
    }
}
