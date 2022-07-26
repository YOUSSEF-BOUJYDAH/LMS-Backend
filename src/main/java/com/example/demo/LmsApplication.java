package com.example.demo;

import com.example.demo.Entities.Student;
import com.example.demo.Entities.Role;
import com.example.demo.Entities.Teacher;
import com.example.demo.Entities.User;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.TeacherRepository;
import com.example.demo.Repository.userRepository;
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
	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
            Role r1 = new Role(null,"Admin");
			Role r2 = new Role(null,"Prof");
            Role r3 = new Role(null,"student");
			User u = new User();
		    Teacher t=new Teacher();
            Student e=new Student();

			u.setUsername("admin");
			u.setPassword("123");
			u.getRoles().add(r1);
	    	t.setUsername("youssef");
	    	t.setPassword("1234");
			t.getRoles().add(r2);
			t.setCIN("Z638322");
			e.setUsername("ali");
			e.setPassword("345");
			e.getRoles().add(r3);
			e.setCNE("Z638322");
			UR.save(u);
			TR.save(t);
            ER.save(e);

            System.out.println("  id "+UR.findById(2L).get().getUsername());

	}
}
