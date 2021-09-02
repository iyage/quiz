package com.example.wkquizapp.Services.serviceimpl;

import com.example.wkquizapp.Repository.CourseRepository;
import com.example.wkquizapp.Services.CourseService;
import com.example.wkquizapp.model.CourseModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@NoArgsConstructor
@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
//    public CourseModel courseModel;
    @Autowired
   private CourseRepository courseRepository;
    @Override
    public void createCourse(CourseModel courseModel) {
        courseRepository.save(courseModel);
    }

    @Override
    public List<CourseModel> findTeacherCourse(Long id) {
        return courseRepository.findCourseModelByTeacherId(id);
    }

    @Override
  public CourseModel  findCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<CourseModel> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<CourseModel> findAllCoursesByStudentId(Long Id) {

        return courseRepository.findCourseModelByStudentsId(Id);
    }

    @Override
    public void updateCourse(CourseModel courseModel) {

    }

}
