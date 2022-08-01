package com.example.demo;

import com.example.demo.Entities.*;
import com.example.demo.Repository.*;
import com.example.demo.Services.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmsApplication implements CommandLineRunner{
	 @Autowired
	 userRepository UR;
     @Autowired
	TeacherRepository TR;
	 @Autowired
	 StudentRepository ER;
	 @Autowired
	 FiliereRepository FR;
	 @Autowired
	 NiveauService NS;
	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
            Role r1 = new Role(null,"Admin");
			Role r2 = new Role(null,"Prof");
			Role r3 = new Role(null,"student");

		Filiere n1=new Filiere();
		Filiere n2=new Filiere();
		Filiere n3=new Filiere();
		Filiere n4=new Filiere();
		n1.setDiplome("Licence");
		n1.setTitre("Genie Informatique");
		n2.setDiplome("Master");
		n2.setTitre("Geni Civil");
		n3.setDiplome("Master");
		n3.setTitre("Finance");
		n4.setDiplome("Master");
		n4.setTitre("Data science");
		n1=FR.save(n1);
		n2=FR.save(n2);
		n3=FR.save(n3);
		n4=FR.save(n4);
		Niveau f1=new Niveau();
		Niveau f2=new Niveau();
		Niveau f3=new Niveau();
		Niveau f4=new Niveau();
		Niveau f5=new Niveau();
		f1.setTitre("premiere annee");
		f2.setTitre("premiere annee");
		f3.setTitre("premiere annee");
		f4.setTitre("premiere annee");
		f5.setTitre("deuxieme annee");
		f1.setLevel(1);
		f2.setLevel(1);
		f3.setLevel(1);
		f4.setLevel(1);
		f5.setLevel(2);
		NS.add(f1,n1.getId());
		NS.add(f2,n2.getId());
		NS.add(f3,n3.getId());
		NS.add(f4,n4.getId());
		NS.add(f5,n4.getId());

		User u = new User();
		Teacher t=new Teacher();
		Teacher t2=new Teacher();
		Teacher t3=new Teacher();
		Student e=new Student();

		u.setUsername("admin");
		u.setPassword("123");
		u.getRoles().add(r1);
		t.setUsername("youssef");
		t.setPassword("1234");
		t.getRoles().add(r2);
		t.setCIN("Z638322");
		t2.setUsername("youssef");
		t2.setPassword("1234");
		t2.getRoles().add(r2);
		t2.setCIN("Z638322");
		t3.setUsername("youssef");
		t3.setPassword("1234");
		t3.getRoles().add(r2);
		t3.setCIN("Z638322");
		e.setUsername("ali");
		e.setPassword("345");
		e.getRoles().add(r3);
		e.setCne("Z638322");
		UR.save(u);
		TR.save(t);
		ER.save(e);

		System.out.println("  id "+UR.findById(2L).get().getUsername());

	}
}
