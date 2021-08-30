package com.example.wkquizapp.Controller;

import com.example.wkquizapp.Services.serviceimpl.CourseServiceImpl;
import com.example.wkquizapp.Services.serviceimpl.QuestionServiceImpl;
import com.example.wkquizapp.Services.serviceimpl.ResultServiceImpl;
import com.example.wkquizapp.model.CourseModel;
import com.example.wkquizapp.model.QuestionModel;
import com.example.wkquizapp.model.ResultModel;
import com.example.wkquizapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class QuestionController {
    @Autowired
    QuestionServiceImpl questionService;
    @Autowired
    CourseServiceImpl courseService;
    @Autowired
    ResultServiceImpl resultService;
  @PostMapping("/savequiz")
    public String saveQuestion(@RequestParam(name= "question")String question,
                             @RequestParam(name= "optionA")String optionA,
                             @RequestParam(value= "answerA", required = false)String answerA,
                             @RequestParam(name= "optionB")String optionB,
                             @RequestParam(value= "answerB",required = false)String answerB,
                             @RequestParam(name= "optionC")String optionC,
                             @RequestParam(value= "answerC",required = false)String answerC,
                             @RequestParam(name= "optionD")String optionD,
                             @RequestParam(value= "answerD", required = false)String answerD,
                                @RequestParam(value = "id") Long id
                             ){
      int  ansA =1;
      int ansB =1;
      int ansC=1;
      int ansD =1;
      if(answerA == null){
          ansA=0;
      }
      if(answerB == null){
          ansB=0;
      }
      if(answerC == null){
          ansC=0;
      }
      if(answerD == null){
          ansD=0;
      }

        questionService.saveQuestionAndAnswer(question,
                optionA,ansA,
                optionB,ansB,
                optionC,ansC,
                optionD,ansD,
                id);
      String route = "redirect:/create_quiz/"+String.valueOf(id);
        return route;
    }

    @GetMapping("/create_quiz/{id}")
    public ModelAndView viewForm(Model model, @PathVariable(value = "id")Long id){
      model.addAttribute("id",id);
        ModelAndView modelAndView = new ModelAndView("edit_quiz");

        return modelAndView;
    }
    @GetMapping("/take_quiz/{id}")
    public  String quizpzge(Model model, @PathVariable(value = "id")Long id){
        System.out.println(id);
        List<QuestionModel> questions = questionService.findQuestionByCourseId(id);
        Set<QuestionModel>questionSet = new HashSet<>(questions);
     model.addAttribute("questions",questionSet);
     model.addAttribute("id", id);
    return "quiz";
  }
  @PostMapping("/submit")
    public String submitForm(HttpServletRequest request, HttpSession session){
      Long courseId = Long.parseLong(request.getParameter("id"));

      int score=0;
     String[] str = request.getParameterValues("questionId");
      for (String id:str) {
        String correctOptionId = id+"q";
          System.out.println(correctOptionId);
          Long correctOption =0L;
          if(request.getParameter(correctOptionId)==null){
           correctOption =0L;
          }
          else {
              correctOption = Long.parseLong(request.getParameter(correctOptionId));
              score += correctOption;
          }
          }
      CourseModel courseModel= new CourseModel();
      courseModel.setId(courseId);
      ResultModel resultModel = new ResultModel();
      resultModel.setCourseModel(courseModel);
      resultModel.setScore(score);
      Student student =  (Student)  session.getAttribute("user");
      resultModel.setStudent(student);
      resultService.saveResult(resultModel);

      return "redirect:/student_profile";
  }


  }


