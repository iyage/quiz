package com.example.wkquizapp.Controller.testfeatures;

import com.example.wkquizapp.enums.Category;
import com.example.wkquizapp.model.CourseModel;
import com.example.wkquizapp.model.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseControllerTestFeatures {
 static   CourseModel course1 = new CourseModel(1L,"Hibernate is good",Category.ANDROID);
  static CourseModel course2 = new CourseModel(2L,"IOS fundemental",Category.IOS);
  static CourseModel course3 = new CourseModel(3L,"learning Spring Boot",Category.JAVA);
  static CourseModel course4= new CourseModel(4L,"IOS basic",Category.IOS);

public static List<CourseModel> courses = new ArrayList<>(){{
  add(course1);
            add(course2);
            add(course3);
            add(course4);
 }};


}
