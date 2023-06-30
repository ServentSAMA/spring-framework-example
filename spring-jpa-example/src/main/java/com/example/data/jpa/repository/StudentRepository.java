package com.example.data.jpa.repository;


import com.example.data.jpa.entity.Student;

public interface StudentRepository extends BaseRepository<Student,String>{

    Student findByUsernameOrderByCreateTimeDesc(String username);

}
