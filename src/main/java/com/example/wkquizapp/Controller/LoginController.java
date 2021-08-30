package com.example.wkquizapp.Controller;

import com.example.wkquizapp.Services.serviceimpl.ResultServiceImpl;
import com.example.wkquizapp.Services.serviceimpl.StudentServiceImpl;
import com.example.wkquizapp.Services.serviceimpl.TeacherServiceImpl;
import com.example.wkquizapp.model.ResultModel;
import com.example.wkquizapp.model.Student;
import com.example.wkquizapp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    ResultServiceImpl resultService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    StudentServiceImpl  studentService;
    @PostMapping("/teacher_login")
    public  String teacherLogin(HttpServletRequest req, HttpSession session, Model model){

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<Teacher> optional =   teacherService.findTeacher(email,password);
        if(optional.isPresent()){
            Teacher teacher = optional.get();
            String role = teacher.getRole().toString();
            session.setAttribute("role",role);
            session.setAttribute("user",teacher);
            return "redirect:/teacher_dashboard";

        }
        else {
            return "redirect:/";
        }

    }
    @PostMapping("/student_login")
    public  String studentLogin(HttpServletRequest req, HttpSession session, Model model){

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<Student> optional =   studentService.findStudent(email,password);
        if(optional.isPresent()){
            Student student = optional.get();
            Long id = student.getId();
            List<ResultModel> results = resultService.findResultByStudentId(id);
             String role = student.getRole().toString();
            session.setAttribute("role",role);
            session.setAttribute("user",student);
            model.addAttribute("results",results);
            return "redirect:/student_profile";

        }
        else {
            return "redirect:/";
        }

    }
    @GetMapping("/logout")
    public  String logout(HttpSession session){
    session.getAttribute("user");
    session.getAttribute("role");
    session.invalidate();
    return "redirect:/";
    }
}
