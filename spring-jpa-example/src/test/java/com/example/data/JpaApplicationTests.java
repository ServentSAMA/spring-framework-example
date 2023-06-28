package com.example.data;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.example.data.entity.QStudent;
import com.example.data.entity.Student;
import com.example.data.repository.ClassRoomRepository;
import com.example.data.repository.TeacherRepository;
import com.example.data.repository.UserRepository;
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
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaApplicationTests {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;


    @Test
    public void initData(){
//        userInitData();
    }

    private void userInitData() {
        try {
            FileInputStream inputStream = new FileInputStream("UserInitData.json");

            StringBuilder stringBuilder = new StringBuilder();

            byte[] temp = new byte[1024];

            while (inputStream.read(temp) > -1){
                stringBuilder.append(Arrays.toString(temp));
            }

            JSONObject jsonObject = JSON.parseObject(stringBuilder.toString());
            List<Student> userList = Lists.newArrayList();
            if (jsonObject.containsKey("data")) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object o : jsonArray) {
                    Student user = JSON.parseObject(o.toString(), Student.class);
                    userList.add(user);
                }
            }
            List<List<Student>> partition = Lists.partition(userList, 1000);
            for (List<Student> users : partition) {
                userRepository.saveAll(users);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void contextLoads() {
        QStudent user = QStudent.student;
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        Student zhangsan = queryFactory.from(user)
                .select(user)
                .where(user.username.eq("zhangsan"))
                .fetchOne();

        System.out.println(zhangsan);
    }
    @Test
    public void jpaRepository(){
        // 使用生成的类
        QStudent user = QStudent.student;
        PageRequest createTime = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("createTime")));
        Page<Student> zhangsanList = userRepository.findAll(createTime);
        System.out.println(zhangsanList.getContent());
    }
}
