package com.example.wkquizapp.Services;

import com.example.wkquizapp.model.Student;
import com.example.wkquizapp.model.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {
    void saveTeacher(Teacher teacher);
    void saveStudent(Student student);
}
