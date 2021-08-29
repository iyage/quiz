package com.example.wkquizapp.Services.serviceimpl;

import com.example.wkquizapp.Repository.ResultRepository;
import com.example.wkquizapp.Services.ResultService;
import com.example.wkquizapp.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultRepository resultRepository;
    @Override
    public void saveResult(ResultModel resultModel) {
        resultRepository.save(resultModel);
    }

    @Override
    public List<ResultModel> findResultByStudentId(Long id) {
        return  resultRepository.findResultModelByStudentId(id);
    }
}
