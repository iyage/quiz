package com.example.wkquizapp.Services.serviceimpl;

import com.example.wkquizapp.Repository.StudentRepository;
import com.example.wkquizapp.Services.StudentService;
import com.example.wkquizapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Optional<Student> findStudent(String email, String password) {
        return studentRepository.findTeacherByEmailAddressAndPassword(email, password);
    }
}
