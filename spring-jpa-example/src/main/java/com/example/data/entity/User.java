package com.example.data.entity;


import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String nickname;

    private String createBy;

    private Date createTime;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
