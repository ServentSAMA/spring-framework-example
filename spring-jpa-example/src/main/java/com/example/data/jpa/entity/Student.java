package com.example.data.jpa.entity;


import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Builder
@Entity(name = "student")
@Data
public class Student {

    /**
     * JPA需要使用无参构造函数
     */
    public Student() {
    }

    /**
     * lombok的Builder注解需要使用这个
     * @param id 主键
     * @param username 用户名
     * @param password 密码
     * @param name 姓名
     * @param nickname 昵称
     * @param hobby 爱好
     * @param idCard 身份证
     * @param phone 电话
     * @param photoUrl 图片URL
     * @param createBy 创建人
     * @param createTime 创建时间
     * @param teacher 老师
     */
    public Student(String id, String username, String password, String name, String nickname, String hobby, String idCard, String phone, String photoUrl, String createBy, Date createTime, List<Teacher> teacher) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.hobby = hobby;
        this.idCard = idCard;
        this.phone = phone;
        this.photoUrl = photoUrl;
        this.createBy = createBy;
        this.createTime = createTime;
        this.teacher = teacher;
    }

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "identifierGeneratorImpl",
            strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "identifierGeneratorImpl",
            strategy = "com.example.data.jpa.config.impl.IdentifierGeneratorImpl")
    private String id;
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
     * 多对多单向原则,如果当前表加入JoinTable注解会生成两个中间表
     * <p>
     * CascadeType.REFRESH：级联刷新，当多个用户同时作操作一个实体，为了用户取到的数据是实时的，在用实体中的数据之前就可以调用一下refresh()方法
     * <p>
     * CascadeType.REMOVE：级联删除，当调用remove()方法删除Order实体时会先级联删除OrderItem的相关数据
     * <p>
     * CascadeType.MERGE：级联更新，当调用了Merge()方法，如果Order中的数据改变了会相应的更新OrderItem中的数据
     * <p>
     * CascadeType.ALL：包含以上所有级联属性
     * <p>
     * CascadeType.PERSIST：级联保存，当调用了Persist() 方法，会级联保存相应的数据
     *
     */
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_student",
            inverseJoinColumns = {@JoinColumn(name = "teacher_id",referencedColumnName = "id")},
            joinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")}
    )
    private List<Teacher> teacher;

}
