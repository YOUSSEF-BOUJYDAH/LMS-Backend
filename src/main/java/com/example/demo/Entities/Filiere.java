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
    @ManyToOne()
    private Niveau niveau ;
    @OneToOne(mappedBy = "maFiliere")
    private Teacher chefFiliere;
    @OneToMany(mappedBy = "filiere")
    @JsonIgnore
    private Set<Student>  students=new HashSet<Student>();
    public void addStudent(Student s){
        s.setFiliere(this);
        this.students.add(s);
    }
   public void removeStudent(Student s){
        s.setFiliere(null);
        this.students.remove(s);
    }
    public  void removeStudents(){
        Iterator<Student> iterator = this.students.iterator();
        while (iterator.hasNext()) {
            Student std = iterator.next();
            std.setFiliere(null);
            iterator.remove();
        }
    }
    public List<Student> getDemandeStudent(){
        List<Student> l= new ArrayList<Student>();
        for(Student s:this.getStudents()){
            if (s.getEtat()==0)
                l.add(s);
        }
        return l;
    }
    public List<Student> getAffecteStudent(){
        List<Student> l= new ArrayList<Student>();
        for(Student s:this.getStudents()){
            if (s.getEtat()==1)
                l.add(s);
        }
        return l;
    }
    public  List<Student> getExlcusedStudent(){
        List<Student> l= new ArrayList<Student>();
        for(Student s:this.getStudents()){
            if (s.getEtat()==-1)
                l.add(s);
        }
        return l;
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
