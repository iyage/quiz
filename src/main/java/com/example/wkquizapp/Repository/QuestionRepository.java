package com.example.wkquizapp.Repository;

import com.example.wkquizapp.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionModel,Long> {
    List<QuestionModel> findQuestionModelsByCourseModelId(Long id);
}
