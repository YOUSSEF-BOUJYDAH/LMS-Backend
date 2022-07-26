package com.example.demo.Repository;

import com.example.demo.Entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClasseRepository extends JpaRepository<Classe,Long> {

}



