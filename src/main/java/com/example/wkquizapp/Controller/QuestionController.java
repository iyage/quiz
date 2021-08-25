package com.example.wkquizapp.Controller;

import com.example.wkquizapp.Services.ServiceImpl.QuestionServiceImpl;
import com.example.wkquizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    QuestionServiceImpl questionService;
  @PostMapping("/svequiz")
    public String saveQuestion(@RequestParam(name= "question")String question,
                             @RequestParam(name= "optionA")String optionA,
                             @RequestParam(value= "answerA", required = false)String answerA,
                             @RequestParam(name= "optionB")String optionB,
                             @RequestParam(value= "answerB",required = false)String answerB,
                             @RequestParam(name= "optionC")String optionC,
                             @RequestParam(value= "answerC",required = false)String answerC,
                             @RequestParam(name= "optionD")String optionD,
                             @RequestParam(value= "answerD", required = false)String answerD
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
                optionD,ansD);
        return "redirect:/edit_page";
    }

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @GetMapping("/edit_page")
    public ModelAndView viewForm(){
        ModelAndView modelAndView = new ModelAndView("quiz_edit_page");
        return modelAndView;
    }
    @GetMapping("/tak_equiz")
    public  String quizpzge(Model model, HttpServletRequest request){
        List<QuestionModel> questions = questionService.findAllQuestions();
     model.addAttribute("questions",questions);
     String[] option = {"A","B","C","D"};
     model.addAttribute("option",option);
    return "quiz_page";
  }
  @PostMapping("/submit")
    public void submitForm(HttpServletRequest request){
     String[] str = request.getParameterValues("questionId");
      for (String e:str) {
          System.out.println(e);
      }
  }




}
