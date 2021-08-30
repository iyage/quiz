package com.example.wkquizapp.Controller;

import com.example.wkquizapp.model.Student;
import com.example.wkquizapp.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @GetMapping("/")
    public ModelAndView home(Model model){
        Teacher teacher = new Teacher();
        Student student = new Student();
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("teacher",teacher);
        model.addAttribute("student",student);
        return modelAndView;
    }
}
