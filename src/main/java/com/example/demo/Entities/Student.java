package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
public class Student extends User{
    String CNE;
    @ManyToOne()
    Filiere filiere;
}
