package com.example.wkquizapp.Services.serviceimpl;

import com.example.wkquizapp.Repository.TeacherRepository;
import com.example.wkquizapp.Services.TeacherService;
import com.example.wkquizapp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public Optional<Teacher> findTeacher(String email, String password) {
        return  teacherRepository.findTeacherByEmailAddressAndPassword(email,password);
    }
}
