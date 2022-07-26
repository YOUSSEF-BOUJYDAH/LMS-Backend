package com.example.demo.Repository;

import com.example.demo.Entities.Teacher;
import com.example.demo.Entities.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin,Long> {
    UserAdmin findByUsernameAndPassword(String username , String password);
}
