package com.example.wkquizapp.Controller;

import com.example.wkquizapp.Services.serviceimpl.CourseServiceImpl;
import com.example.wkquizapp.model.CourseModel;
import com.example.wkquizapp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    CourseServiceImpl courseService;
    @GetMapping("/teacher_dashboard")
    public  String contactPage(Model model, HttpSession session){
      Teacher teacher = (Teacher) session.getAttribute("user");
      Long id  = teacher.getId();
         List<CourseModel> courses =  courseService.findTeacherCourse(id);
        CourseModel courseModel = new CourseModel();
        model.addAttribute("course",courseModel);
        model.addAttribute("courses",courses);
        return "teacherdashboard";
    }

    @GetMapping("/teacher")
    public String viewTeachers(){
        return "teachers";

    }



}
