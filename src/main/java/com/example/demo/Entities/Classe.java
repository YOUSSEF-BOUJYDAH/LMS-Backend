package com.example.demo.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Classe implements Serializable {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String name;
    @Column()
    private int nombre;
    @Column()
    private String description;
}
