package com.example.data.entity;


import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "student")
@Data
public class Student {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 照片url
     */
    private String photoUrl;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 所属老师
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
