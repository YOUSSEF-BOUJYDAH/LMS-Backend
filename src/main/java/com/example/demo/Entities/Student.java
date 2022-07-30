package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
public class Student extends User{
    private String CNE;
    private int etat=0;
    @ManyToOne()
    private Filiere filiere;

    public void setAffected(){
        this.setEtat(1);
    }
    public void setDemanded(){
        this.setEtat(0);
    }
    public void setRefused(){
        this.setEtat(-1);
    }
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

        return this.getId() != null && this.getId().equals(((Student) obj).getId());
    }
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
