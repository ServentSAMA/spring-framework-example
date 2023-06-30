package com.example.data.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "hobby")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 120)
    private String id;

    @Column(name = "hobby_name", length = 40)
    private String hobbyName;

//    @ManyToMany(mappedBy = "student", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    private List<Student> studentList;
}
