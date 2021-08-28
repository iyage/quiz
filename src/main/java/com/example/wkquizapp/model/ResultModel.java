package com.example.wkquizapp.model;

import javax.persistence.*;

@Entity
public class ResultModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private  int score;
    @ManyToOne
    private Student student;
}
