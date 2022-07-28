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
    @ManyToOne()
    private Filiere filiere;
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
        return 2022;
    }
}
