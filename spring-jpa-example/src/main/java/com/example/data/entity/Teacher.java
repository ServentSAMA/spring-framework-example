package com.example.data.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity(name = "teacher")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer classRoomId;

    private String createBy;

    private Date createTime;
    /**
     * ToString.Exclude作用防止toString死循环
     */
    @ToString.Exclude
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<User> users;

}
