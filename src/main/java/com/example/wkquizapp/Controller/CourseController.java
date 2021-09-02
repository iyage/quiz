package com.example.wkquizapp.Controller;

import com.example.wkquizapp.Services.serviceimpl.CourseServiceImpl;
import com.example.wkquizapp.model.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;
@PostMapping("/create_course")
    public  String createCourse(@ModelAttribute(value = "course")CourseModel courseModel){
    courseService.createCourse(courseModel);
    return "redirect:/teacher_dashboard";
}
@GetMapping("/create_content/{id}")
    public String  createContentpage(@PathVariable(value = "id")Long id, Model model){
    CourseModel  courseModel = courseService.findCourseById(id);
    model.addAttribute("id",id);
    return"/richtexteditor";
}
//@RequestMapping(value = "/save_content",method = RequestMethod.PUT)
@PostMapping("/save_content")
    public  String saveContent(@RequestParam(name = "id")Long id,
                               @RequestParam(name = "content")String content){
    CourseModel  courseModel = courseService.findCourseById(id);
//    CourseModel  courseModel = new CourseModel();
//    courseModel.setId(id);
    courseModel.setContent(content);
    courseService.createCourse(courseModel);
  String route = "redirect:/create_content/"+String.valueOf(id);
    return route;
}
@GetMapping("/courses")
    public String viewCourses(Model model){
   List<CourseModel> courseList = courseService.findAllCourses();
;
   model.addAttribute("courselist",courseList);
    return "all_course";

   }
@GetMapping("/take_course/{id}")
    public String  viewCourse(@PathVariable(value = "id")Long id, Model model){
    CourseModel courseModel = courseService.findCourseById(id);
    model.addAttribute("course",courseModel);

      return "course";
}

}
