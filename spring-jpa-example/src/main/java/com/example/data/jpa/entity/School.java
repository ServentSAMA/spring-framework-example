package com.example.data.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity(name = "school")
public class School {

    @Id
    @GeneratedValue(generator = "identifierGeneratorImpl",
            strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "identifierGeneratorImpl",
            strategy = "com.example.data.jpa.config.impl.IdentifierGeneratorImpl")
    private String id;
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

    private String introduce;


}
