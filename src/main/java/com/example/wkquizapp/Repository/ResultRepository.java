package com.example.wkquizapp.Repository;

import com.example.wkquizapp.model.ResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<ResultModel,Long> {
    List<ResultModel> findResultModelByStudentId(Long id);
}
