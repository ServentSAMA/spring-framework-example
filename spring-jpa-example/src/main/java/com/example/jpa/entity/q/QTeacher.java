package com.example.jpa.entity.q;

import com.example.jpa.entity.QUser;
import com.example.jpa.entity.Teacher;
import com.example.jpa.entity.User;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QTeacher is a Querydsl query type for Teacher
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeacher extends EntityPathBase<Teacher> {

    private static final long serialVersionUID = 983034555L;

    public static final QTeacher teacher = new QTeacher("teacher");

    public final StringPath classRoomId = createString("classRoomId");

    public final StringPath createBy = createString("createBy");

    public final StringPath createTime = createString("createTime");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final ListPath<User, com.example.jpa.entity.QUser> users = this.<User, com.example.jpa.entity.QUser>createList("users", User.class, QUser.class, PathInits.DIRECT2);

    public QTeacher(String variable) {
        super(Teacher.class, forVariable(variable));
    }

    public QTeacher(Path<? extends Teacher> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeacher(PathMetadata metadata) {
        super(Teacher.class, metadata);
    }

}

