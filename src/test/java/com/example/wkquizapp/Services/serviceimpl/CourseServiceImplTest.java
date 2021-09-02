package com.example.wkquizapp.Services.serviceimpl;
import  static com.example.wkquizapp.Controller.testfeatures.testFeatures.*;
import static org.mockito.Mockito.when;

import com.example.wkquizapp.Repository.CourseRepository;
import com.example.wkquizapp.enums.Role;
import com.example.wkquizapp.model.CourseModel;
import com.example.wkquizapp.model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import  static  org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {
    @Mock
    private CourseRepository courseRepository;
    @InjectMocks
    private  CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
        courseService = new CourseServiceImpl(courseRepository);
        course1.setCourseDescription("hello world");
        course1.setContent("this language is goood for everybody and " +
                "all should get it");
    }

    @Disabled
    @Test
    void createCourse() {
    }
  @Disabled
    @Test
    void findTeacherCourse() {
   Teacher teacher = new Teacher(
              1l,
              "ade",
              "segun",
              "ade@gmail.com",
              "1234",
              Role.TEACHER,
              "Am a tacher");
   course1.setTeacher(teacher);
   course2.setTeacher(teacher);
   List<CourseModel>teacherCourse = new ArrayList<>(){{
       add(course1);
       add(course2);
   }};
   when(courseRepository.findCourseModelByTeacherId(1l)).thenReturn(teacherCourse);
       List<CourseModel>courseModelList = courseService.findTeacherCourse(1l);
       assertThat(courseModelList).isSameAs(teacherCourse);
    }
    @Test
    void findCourseById() {
        Long id=1l;
    when(courseRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(findbyid(id)));
     CourseModel courseModel = courseService.findCourseById(1l);
        assertThat(courseModel).isSameAs(course1);
    }

    @Test
    void findAllCourses() {
        when(courseRepository.findAll()).thenReturn(courses);
        List<CourseModel>courseModelList = courseService.findAllCourses();
        assertThat(courseModelList).isSameAs(courses);
    }
    @Disabled
    @Test
    void findAllCoursesByStudentId() {
    }
    @Disabled
    @Test
    void updateCourse() {
    }
}