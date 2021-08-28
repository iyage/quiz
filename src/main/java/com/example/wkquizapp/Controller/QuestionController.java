package com.example.wkquizapp.Controller;

import com.example.wkquizapp.Services.serviceimpl.QuestionServiceImpl;
import com.example.wkquizapp.model.CourseModel;
import com.example.wkquizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class QuestionController {
    private
    @Autowired
    QuestionServiceImpl questionService;
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
    @GetMapping("/take_quiz")
    public  String quizpzge(Model model, HttpServletRequest request){
        List<QuestionModel> questions = questionService.findAllQuestions();
        Set<QuestionModel>questionSet = new HashSet<>(questions);
     model.addAttribute("questions",questionSet);
     String[] option = {"A","B","C","D"};
     model.addAttribute("option",option);
    return "quiz";
  }
  @PostMapping("/submit")
    public void submitForm(HttpServletRequest request){
     Long score=0L;
     String[] str = request.getParameterValues("questionId");
      for (String id:str) {
        String correctOptionId = id+"q";
        Long correctOption = Long.parseLong(request.getParameter(correctOptionId));
        score+=correctOption;
          }
      }

  }


