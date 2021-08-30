package com.example.wkquizapp.Repository;

import com.example.wkquizapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
Optional<Teacher> findTeacherByEmailAddressAndPassword(String email,String pasword);
}
