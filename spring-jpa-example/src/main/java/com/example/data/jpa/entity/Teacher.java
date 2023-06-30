package com.example.data.jpa.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Entity(name = "teacher")
@Data
@Builder
public class Teacher {

    public Teacher() {
    }

    public Teacher(String id, String name, String nickname, String hobby, String idCard, String phone, String photoUrl, Integer classRoomId, String createBy, Date createTime, List<Student> students) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.hobby = hobby;
        this.idCard = idCard;
        this.phone = phone;
        this.photoUrl = photoUrl;
        this.classRoomId = classRoomId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.students = students;
    }

    @Id
    @Column(length = 120, name = "id", unique = true)
    @GeneratedValue(generator = "identifierGeneratorImpl",
            strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "identifierGeneratorImpl",
            strategy = "com.example.data.jpa.config.impl.IdentifierGeneratorImpl")
    private String id;

    private String name;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 爱好
     */
    @Column(name = "hobby")
    private String hobby;
    /**
     * 身份证
     */
    @Column(name = "id_card", length = 18)
    private String idCard;
    /**
     * 手机号
     */
    @Column(name = "phone", length = 11)
    private String phone;
    /**
     * 照片url
     */
    private String photoUrl;

    private Integer classRoomId;

    private String createBy;

    private Date createTime;
    /**
     * ToString.Exclude作用防止toString死循环
     *
     * JoinTable介绍:
     *  name:中间表名称
     *  joinColumns：配置当前对象在中间表的外键
     *  referencedColumnName：参照的主表主键
     *  inverseJoinColumns：配置对方对象在中间表的外键
     *  保存时级联添加JoinTable在那个类上，就保存那个类
     */
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = Student.class)
    @JoinTable(name = "teacher_student",
            joinColumns = {@JoinColumn(name = "teacher_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")}
    )
    private List<Student> students;


}
