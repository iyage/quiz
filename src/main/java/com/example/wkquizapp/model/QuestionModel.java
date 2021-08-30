package com.example.wkquizapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class QuestionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_d", nullable = false)
    private Long id;
    private String content;
    @ManyToOne
    private  CourseModel courseModel;
    @OneToMany(mappedBy = "questionModel")
    private  Set<AnswerModel>answers = new HashSet<>();
}
