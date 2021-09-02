package com.example.wkquizapp.model;

import com.example.wkquizapp.enums.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CourseModel {
    public CourseModel(Long id, String courseTitle, Category category) {
        this.id = id;
        this.courseTitle = courseTitle;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    String courseTitle;
    @ManyToMany
    List<Student> students = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private  Teacher teacher;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;
    private  String CourseDescription;
    String content;

}

