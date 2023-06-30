package com.example.data.jpa.entity.q;

import com.example.data.jpa.entity.Student;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 1874481251L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudent student = new QStudent("student");

    public final StringPath createBy = createString("createBy");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath hobby = createString("hobby");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath idCard = createString("idCard");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath photoUrl = createString("photoUrl");

    public final QTeacher teacher;

    public final StringPath username = createString("username");

    public QStudent(String variable) {
        this(Student.class, forVariable(variable), INITS);
    }

    public QStudent(Path<? extends Student> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudent(PathMetadata metadata, PathInits inits) {
        this(Student.class, metadata, inits);
    }

    public QStudent(Class<? extends Student> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.teacher = inits.isInitialized("teacher") ? new QTeacher(forProperty("teacher")) : null;
    }

}

