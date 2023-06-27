package com.example.jpa;


import com.example.jpa.entity.User;
import com.example.jpa.entity.q.QUser;
import com.example.jpa.repository.ClassRoomRepository;
import com.example.jpa.repository.TeacherRepository;
import com.example.jpa.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;

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
    public void contextLoads() {
        QUser user = QUser.user;
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        User zhangsan = queryFactory.from(user)
                .select(user)
                .where(user.username.eq("zhangsan"))
                .fetchOne();

        System.out.println(zhangsan);
    }
    @Test
    public void jpaRepository(){
        // 使用生成的类
        QUser user = QUser.user;
        PageRequest createTime = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("createTime")));
        Page<User> zhangsanList = userRepository.findAll(createTime);
        System.out.println(zhangsanList.getContent());
    }
}
