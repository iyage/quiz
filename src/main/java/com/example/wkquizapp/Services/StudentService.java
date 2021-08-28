package com.example.wkquizapp.Services;

import com.example.wkquizapp.model.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface StudentService {

        Optional<Student> findStudent(String email, String password);

}
