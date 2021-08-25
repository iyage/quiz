package com.example.wkquizapp.Repository;

import com.example.wkquizapp.model.AnswerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerModel,Long> {
}
