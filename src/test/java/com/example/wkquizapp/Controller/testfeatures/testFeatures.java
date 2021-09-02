package com.example.wkquizapp.Controller.testfeatures;

import com.example.wkquizapp.enums.Category;
import com.example.wkquizapp.enums.Role;
import com.example.wkquizapp.model.CourseModel;
import com.example.wkquizapp.model.Student;
import com.example.wkquizapp.model.Teacher;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter

public class testFeatures {
public   static   CourseModel course1 = new CourseModel(1L,"Hibernate is good",Category.ANDROID);
 public static CourseModel course2 = new CourseModel(2L,"IOS fundemental",Category.IOS);
  static CourseModel course3 = new CourseModel(3L,"learning Spring Boot",Category.JAVA);
  static CourseModel course4= new CourseModel(4L,"IOS basic",Category.IOS);


    public static List<CourseModel> courses = new ArrayList<>(){{
            add(course1);
            add(course2);
            add(course3);
            add(course4);
 }};
    public  static CourseModel findbyid(Long id){
        CourseModel courseModel = new CourseModel();
      for(CourseModel e:courses){
          if(e.getId()==id){
              courseModel=e;
          }
      }
   return courseModel;
    }
    public  static CourseModel findByTeacher(Long id){
        CourseModel courseModel = new CourseModel();
        for(CourseModel e:courses){
            if(e.getId()==id){
                courseModel=e;
            }
        }
        return courseModel;
    }

}
