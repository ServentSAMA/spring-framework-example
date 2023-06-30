package com.example.data.jpa.entity.q;

import com.example.data.jpa.entity.Student;
import com.example.data.jpa.entity.Teacher;
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

    private static final long serialVersionUID = -1980917238L;

    public static final QTeacher teacher = new QTeacher("teacher");

    public final NumberPath<Integer> classRoomId = createNumber("classRoomId", Integer.class);

    public final StringPath createBy = createString("createBy");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath hobby = createString("hobby");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath idCard = createString("idCard");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath phone = createString("phone");

    public final StringPath photoUrl = createString("photoUrl");

    public final ListPath<Student, QStudent> users = this.<Student, QStudent>createList("users", Student.class, QStudent.class, PathInits.DIRECT2);

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

