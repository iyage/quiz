package com.example.wkquizapp.Repository;

import com.example.wkquizapp.model.Student;
import com.example.wkquizapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findTeacherByEmailAddressAndPassword(String email, String pasword);
}
