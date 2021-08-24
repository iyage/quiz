
package com.example.wkquizapp.Services.ServiceImpl;
import com.example.wkquizapp.Repository.AnswerRepository;
import com.example.wkquizapp.Repository.QuestionRepository;
import com.example.wkquizapp.model.AnswerModel;
import com.example.wkquizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public boolean saveQuestionAndAnswer(String question,
                                         String optionA, int answerA,
                                         String optionB, int answerB,
                                         String optionC, int answerC,
                                         String optionD, int answerD) {


        List<String> options = new ArrayList<>(){{
            add(optionA);
            add(optionB);
            add(optionC);
            add(optionD);
        }};
        List<Integer> answer = new ArrayList<>(){{
            add(answerA);
            add((answerB));
            add(answerC);
            add(answerD);
        }};

        QuestionModel questionModel = new QuestionModel();
        questionModel.setContent(question);
        questionRepository.save(questionModel);
        Set<AnswerModel> answers = new HashSet<>();
       for(int i= 0;i<4;i++){
           AnswerModel answerModel = new AnswerModel();
           answerModel.setContent(options.get(i));
           answerModel.setCorrect(answer.get(i));
           answerModel.setQuestionModel(questionModel);
           answerRepository.save(answerModel);
       }

        return true;
    }
}
