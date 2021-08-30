package com.example.wkquizapp.model;

import com.example.wkquizapp.enums.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private  String emailAddress;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String bio;
    @ManyToMany(mappedBy = "students")
    private List<CourseModel>courseTaken=new ArrayList<>();

}
