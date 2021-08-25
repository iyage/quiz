package com.example.wkquizapp.Services.ServiceImpl;

import com.example.wkquizapp.model.QuestionModel;

import java.util.List;

public interface QuestionService {
    boolean saveQuestionAndAnswer(String question,
                                  String optionA,int answerA,
                                  String optionB,int  answerB,
                                  String optionC,int answerC,
                                  String optionD,int answerD);
    List<QuestionModel>findAllQuestions();
}
