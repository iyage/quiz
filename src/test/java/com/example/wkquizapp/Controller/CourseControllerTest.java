package com.example.wkquizapp.Controller;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.example.wkquizapp.Repository.CourseRepository;
import com.example.wkquizapp.Services.serviceimpl.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import  static  com.example.wkquizapp.Controller.testfeatures.testFeatures.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class CourseControllerTest  {
@Autowired
private MockMvc mockMvc;
@Mock
private CourseRepository courseRepository;
@MockBean
    CourseServiceImpl courseService;
    @InjectMocks
    CourseController controller;
    @BeforeEach
    void setUp() throws Exception {

        when(courseService.findAllCourses()).thenReturn(courses);
    }
    @Test
    public  void viewCourse() throws Exception {


        this.mockMvc.perform(get("/courses"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }
}