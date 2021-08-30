
package com.example.wkquizapp.Services.serviceimpl;
import com.example.wkquizapp.Repository.AnswerRepository;
import com.example.wkquizapp.Repository.QuestionRepository;
import com.example.wkquizapp.Services.QuestionService;
import com.example.wkquizapp.model.AnswerModel;
import com.example.wkquizapp.model.CourseModel;
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
                                         String optionD, int answerD,
                                         Long id) {


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
        Set<AnswerModel> answerModelSet = new HashSet<>();
        CourseModel courseModel = new CourseModel();
        courseModel.setId(id);
        QuestionModel questionModel = new QuestionModel();
        questionModel.setCourseModel(courseModel);
        questionModel.setContent(question);
        questionRepository.save(questionModel);
        Set<AnswerModel> answers = new HashSet<>();
       for(int i= 0;i<4;i++){
           AnswerModel answerModel = new AnswerModel();
           answerModel.setContent(options.get(i));
           answerModel.setCorrect(answer.get(i));
           answerModel.setQuestionModel(questionModel);
           answerRepository.save(answerModel);
           answerModelSet.add(answerModel);
       }
       questionModel.setAnswers(answerModelSet);
        for (AnswerModel e:questionModel.getAnswers()) {
            System.out.println(e.getContent());
        }

        return true;
    }

    @Override
    public List<QuestionModel> findAllQuestions() {
     return questionRepository.findAll();
    }

    @Override
    public Long findQuestionById(Long id) {
      QuestionModel questionModel = questionRepository.getById(id);
        for (AnswerModel ans: questionModel.getAnswers()) {
            if(ans.getCorrect()==1){
                return ans.getId();
            }
        }

   return -1L;
    }

    @Override
    public List<QuestionModel> findQuestionByCourseId(Long id) {
        return  questionRepository.findQuestionModelsByCourseModelId(id);
    }
}
