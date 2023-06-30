package com.example.data.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 学校名称
     */
    @Column(name = "school_name", length = 128)
    private String schoolName;
    /**
     * 学校官网地址
     */
    @Column(name = "school_url")
    private String schoolUrl;



}
