package com.example.wkquizapp.model;

import com.example.wkquizapp.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserModel {
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
}
