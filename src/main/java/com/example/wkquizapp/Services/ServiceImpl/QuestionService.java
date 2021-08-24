package com.example.wkquizapp.Services.ServiceImpl;

public interface QuestionService {
    boolean saveQuestionAndAnswer(String question,
                                  String optionA,int answerA,
                                  String optionB,int  answerB,
                                  String optionC,int answerC,
                                  String optionD,int answerD);
}
