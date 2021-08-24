package com.example.wkquizapp.Repository;

import com.example.wkquizapp.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionModel,Long> {
}
