package com.example.wkquizapp.Services.serviceimpl;

import com.example.wkquizapp.Repository.TeacherRepository;
import com.example.wkquizapp.Repository.StudentRepository;
import com.example.wkquizapp.Services.RegistrationService;
import com.example.wkquizapp.model.Student;
import com.example.wkquizapp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    StudentRepository studentRepository;
    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void saveStudent(Student student) {
    studentRepository .save(student);
    }
}
