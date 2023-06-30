package com.example.data.jpa.entity;

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
     */
    @ToString.Exclude
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Student> users;

}
