package com.example.data.jpa.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "class_room")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 120)
    private String id;

    private String name;

}
