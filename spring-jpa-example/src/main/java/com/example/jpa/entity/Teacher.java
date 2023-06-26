package com.example.jpa.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity(name = "teacher")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String classRoomId;

    private String createBy;

    private String createTime;

    @ToString.Exclude
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<User> users;

}
