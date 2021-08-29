package com.example.wkquizapp.Services;

import com.example.wkquizapp.model.CourseModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {
    void createCourse(CourseModel courseModel);
    List<CourseModel>findTeacherCourse(Long id);
    public CourseModel findCourseById(Long id);
    List<CourseModel>findAllCourses();
    List<CourseModel>findAllCoursesByStudentId(Long Id);
    void updateCourse(CourseModel courseModel);
}
