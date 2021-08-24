package com.example.wkquizapp.model;

import com.example.wkquizapp.enums.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    String courseTitle;
    @Enumerated(EnumType.STRING)
    private Category category;


    }

