package com.example.data;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import com.example.data.jpa.entity.Student;
import com.example.data.jpa.entity.Teacher;
import com.example.data.jpa.entity.q.QStudent;
import com.example.data.jpa.repository.ClassRoomRepository;
import com.example.data.jpa.repository.TeacherRepository;
import com.example.data.jpa.repository.StudentRepository;
import com.google.common.collect.Lists;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaApplicationTests {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;


    @Test
    public void initData(){
        Date date = new Date();
        Teacher xingye = Teacher.builder().classRoomId(1).idCard("1984").name("周星驰").phone("178999222").nickname("星爷").photoUrl("http:").createBy("shen").createTime(date).build();
        Teacher dashu = Teacher.builder().classRoomId(1).idCard("1984").name("吴孟达").phone("178999333").nickname("达叔").photoUrl("http:").createBy("shen").createTime(date).build();
        Teacher chenglong = Teacher.builder().classRoomId(1).idCard("1984").name("成龙").phone("178912399").nickname("龙叔").photoUrl("http:").createBy("shen").createTime(date).build();

        Student qianwei = Student.builder().password("123456").teacher(Lists.newArrayList(chenglong,dashu)).name("前卫").nickname("前卫").username("qianwei").phone("1234567").photoUrl("http:").idCard("123456").createTime(date).createBy("shen").build();
        Student buzhihuo = Student.builder().password("123456").teacher(Lists.newArrayList(chenglong,xingye)).name("不知火").nickname("不知火").username("buzhihuo").phone("1234567").photoUrl("http:").idCard("123456").createTime(date).createBy("shen").build();
        Student jiutun = Student.builder().password("123456").teacher(Lists.newArrayList(chenglong,dashu)).name("酒吞童子").nickname("酒吞童子").username("jiutuntongzi").phone("1234567").photoUrl("http:").idCard("123456").createTime(date).createBy("shen").build();
        Student cimu = Student.builder().password("123456").teacher(Lists.newArrayList(chenglong,xingye,dashu)).name("茨木童子").nickname("茨木童子").username("cimutongzi").phone("1234567").photoUrl("http:").idCard("123456").createTime(date).createBy("shen").build();

        ArrayList<Student> students = Lists.newArrayList(qianwei, buzhihuo, jiutun, cimu);
        studentRepository.saveAll(students);
    }

    @Test
    public void queryFactory() {
        QStudent user = QStudent.student;
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        Student zhangsan = queryFactory.from(user)
                .select(user)
                .where(user.username.eq("buzhihuo"))
                .fetchOne();

        System.out.println(zhangsan);
    }
    @Test
    public void jpaRepository(){
        // 使用生成的类
        QStudent user = QStudent.student;
        PageRequest createTime = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("createTime")));
        Page<Student> zhangsanList = studentRepository.findAll(createTime);
        System.out.println(zhangsanList.getContent());
    }
}
