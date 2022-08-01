package com.example.demo.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends User implements Serializable {
    String CIN ;
    @OneToOne
    @JsonIgnore
    Filiere maFiliere;
}
