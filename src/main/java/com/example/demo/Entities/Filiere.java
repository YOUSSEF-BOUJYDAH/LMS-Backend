package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Filiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String diplome;
    @OneToMany(mappedBy = "filiere" , cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<Niveau> niveaux=new HashSet<Niveau>() ;
    @OneToOne(mappedBy = "maFiliere")
    private Teacher chefFiliere;

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        return this.getId() != null && this.getId().equals(((Filiere) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
    public void addNiveau(Niveau n){
        n.setFiliere(this);
        this.niveaux.add(n);
    }
    public void removeNiveau(Niveau f){
        f.setFiliere(null);
        this.niveaux.remove(f);
    }
    public void removeNiveaux(){
        Iterator<Niveau> iterator = this.niveaux.iterator();
        while (iterator.hasNext()) {
            Niveau f = iterator.next();
            f.setFiliere(null);
            iterator.remove();
        }
    }

}
