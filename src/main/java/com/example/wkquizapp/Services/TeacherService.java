package com.example.wkquizapp.Services;

import com.example.wkquizapp.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TeacherService {
    Optional<Teacher> findTeacher(String email, String password);
}
