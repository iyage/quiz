package com.example.wkquizapp.Controller;

import com.example.wkquizapp.Repository.StudentRepository;
import com.example.wkquizapp.Services.serviceimpl.CourseServiceImpl;
import com.example.wkquizapp.Services.serviceimpl.ResultServiceImpl;
import com.example.wkquizapp.model.CourseModel;
import com.example.wkquizapp.model.ResultModel;
import com.example.wkquizapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    ResultServiceImpl resultService;
    @Autowired
    StudentRepository studentRepository;
   @Autowired
    CourseServiceImpl courseService;
    @GetMapping("/student_profile")
    public  String viewStudentProfile(Model model, HttpSession session){
        Student student = (Student)  session.getAttribute("user");
        List<CourseModel> courseList = courseService.findAllCoursesByStudentId(student.getId());
        List<ResultModel> resultList = resultService.findResultByStudentId(student.getId());
        model.addAttribute("results",resultList);
        model.addAttribute("courselist",courseList);
        return "student_dashboard";
    }
    @GetMapping("register_course/{id}")
    public String registerCourse(@PathVariable(value = "id")Long id,HttpSession session){

        if(session.getAttribute("user")!=null && session.getAttribute("role").toString().equalsIgnoreCase("STUDENT")){
            Student student = (Student) session.getAttribute("user");
            CourseModel courseModel = courseService.findCourseById(id);
            List<CourseModel> courseModelList = new ArrayList<>();
            List<Student> studentList = new ArrayList<>();
            courseModelList.add(courseModel);
            student.setCourseTaken(courseModelList);
        studentList.add(student);
            courseModel.setStudents(studentList);
            courseService.createCourse(courseModel);
            studentRepository.save(student);
            return "redirect:/student_profile";  }
        else{
            return "redirect:/";  }
        }

}