package com.example.wkquizapp.Controller;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest  {
@Autowired
private MockMvc mockMvc;
    @BeforeEach
    void setUp() {
    }
    @Test
    public  void viewCourse() throws Exception {
        this.mockMvc.perform(get("/courses"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}