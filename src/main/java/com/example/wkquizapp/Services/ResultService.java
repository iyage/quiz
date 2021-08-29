package com.example.wkquizapp.Services;

import com.example.wkquizapp.model.ResultModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {
    void saveResult(ResultModel resultModel);
    List<ResultModel> findResultByStudentId(Long id);
}
