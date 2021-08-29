package com.example.wkquizapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
public class ResultModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private  int score;
    @ManyToOne
    private Student student;
    @ManyToOne
    private CourseModel courseModel;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate date = LocalDate.now();

}
