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
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Titre;
    @ManyToOne()
   private Niveau niveau ;
    @OneToOne(mappedBy = "maFiliere")
    private Teacher chefFiliere;
    @OneToMany(mappedBy = "filiere")
    private Set<Student>  students=new HashSet<Student>();
    void addStudent(Student s){
        s.setFiliere(this);
        this.students.add(s);
    }
    void removeStudent(Student s){
        s.setFiliere(null);
        this.students.remove(s);
    }
    void removeStudents(){
        Iterator<Student> iterator = this.students.iterator();
        while (iterator.hasNext()) {
            Student std = iterator.next();
            std.setFiliere(null);
            iterator.remove();
        }
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

        return this.getId() != null && this.getId().equals(((Filiere) obj).getId());
    }
    @Override
    public int hashCode() {
        return 2022;
    }
}
