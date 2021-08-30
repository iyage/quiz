package com.example.wkquizapp.Controller;
import com.example.wkquizapp.Services.serviceimpl.RegistrationServiceImpl;
import com.example.wkquizapp.enums.Role;
import com.example.wkquizapp.model.Student;
import com.example.wkquizapp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {
    @Autowired
    RegistrationServiceImpl registrationService;
    @PostMapping("/save_teacher")
    public  String saveTeacher(HttpServletRequest request){
    if(((String)request.getParameter("role")).equalsIgnoreCase("Teacher")){
        Teacher teacher = new Teacher();
        teacher.setRole(Role.TEACHER);
        teacher.setFirstName((String) request.getParameter("firstName"));
        teacher.setLastName ((String)request.getParameter("lastName"));
        teacher.setEmailAddress((String)request.getParameter("email"));
        teacher.setPassword((String)request.getParameter("password"));
        registrationService.saveTeacher(teacher);
    }else{
       Student  student= new Student();
        student.setRole(Role.STUDENT);
        student.setFirstName((String) request.getParameter("firstName"));
       student.setLastName ((String)request.getParameter("lastName"));
       student.setEmailAddress((String)request.getParameter("email"));
        student.setPassword((String)request.getParameter("password"));
        registrationService.saveStudent(student);
    }

        return "redirect:/";
    }
}
