package com.example.wkquizapp.Services;

import com.example.wkquizapp.model.QuestionModel;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface QuestionService {
    boolean saveQuestionAndAnswer(String question,
                                  String optionA,int answerA,
                                  String optionB,int  answerB,
                                  String optionC,int answerC,
                                  String optionD,int answerD,
                                  Long id);
   List<QuestionModel> findAllQuestions();
    public Long findQuestionById(Long id);
    List<QuestionModel>findQuestionByCourseId(Long id);
}
